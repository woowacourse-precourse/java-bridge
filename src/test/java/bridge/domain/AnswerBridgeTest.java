package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("AnswerBridge 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AnswerBridgeTest {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @ParameterizedTest
    @ValueSource(ints = {2, 21, 0})
    void 생성자는_허용되지_않은_길이의_다리를_입력받으면_IllegalArgumentException을_던진다(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        Assertions.assertThatThrownBy(() -> new AnswerBridge(bridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이는 3부터 20 사이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void 생성자는_3부터_20사이의_길이를_가진_다리를_입력받으면_예외를_던지지_않는다(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        AnswerBridge answerBridge = new AnswerBridge(bridge);
        assertThat(answerBridge).isNotNull();
    }

    @Test
    void check_메서드는_올바르지_않은_다리_위치를_입력한다면_IllegalArgumentException을_던진다() {
        AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));

        assertThatThrownBy(() -> answerBridge.check(Round.valueOf(4), Direction.DOWN))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 다리의 범위를 벗어났습니다.");
    }

    @Test
    void check_메서드는_정답을_입력했다면_MoveResult_SUCCESS를_반환한다() {
        AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));

        MoveResult result = answerBridge.check(Round.valueOf(1), Direction.UP);

        assertThat(result).isEqualTo(MoveResult.SUCCESS);
    }

    @Test
    void check_메서드는_오답을_입력했다면_MoveResult_FAIL을_반환한다() {
        AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));

        MoveResult result = answerBridge.check(Round.valueOf(1), Direction.DOWN);

        assertThat(result).isEqualTo(MoveResult.FAIL);
    }

    @Test
    void isLastRound_메서드는_라운드를_입력받아_마지막_라운드가_아닌_경우_false를_반환한다() {
        AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));

        assertThat(answerBridge.isLastRound(Round.valueOf(1))).isFalse();
    }

    @Test
    void isLastRound_메서드는_라운드를_입력받아_마지막_라운드인_경우_true를_반환한다() {
        AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U"));

        assertThat(answerBridge.isLastRound(Round.valueOf(3))).isTrue();
    }
}
