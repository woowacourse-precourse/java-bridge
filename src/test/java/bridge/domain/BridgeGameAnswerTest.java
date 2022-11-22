package bridge.domain;


import static org.assertj.core.api.Assertions.*;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.common.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameAnswerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    @DisplayName("[예외] 올바르지 않은 bridge size일 때 BrideGameAnswer 오류 발생한다.")
    void createBridgeAnswer(int size) {
        final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        final BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThatThrownBy(() -> new BridgeGameAnswer(bridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.isInvalidBridgeSize());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 4})
    @DisplayName("[예외] 진행된 round 이외의 숫자를 입력하면 에러 발생")
    void check_invalid_round(int number) {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);

        assertCheckException(gameAnswer, number);
    }

    private void assertCheckException(BridgeGameAnswer bridgeGameAnswer, int number) {
        assertThatThrownBy(() -> bridgeGameAnswer.check(Round.valueOf(number), Move.UP))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.isInvalidRoundRange());
    }

    @Test
    @DisplayName("[정상] Check 메서드에 정답이면 MovingResult.SUCCESS 반환한다.")
    void checkSuccess() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);

        MoveResult result = gameAnswer.check(Round.valueOf(1), Move.UP);
        assertThat(result).isEqualTo(MoveResult.SUCCESS);
    }

    @Test
    @DisplayName("[정상] Check 메서드에 오답이면 MovingResult.FAIL 반환한다.")
    void checkFail() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);

        MoveResult result = gameAnswer.check(Round.valueOf(1), Move.DOWN);
        assertThat(result).isEqualTo(MoveResult.FAIL);
    }

    @Test
    @DisplayName("[정상] 마지막 라운드일 시, true 반환한다.")
    void isLastRoundWhenLastParameter() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);;

        assertThat(gameAnswer.isLastRound(Round.valueOf(3))).isTrue();
    }

    @Test
    @DisplayName("[정상] 마지막 라운드가 아닐시, false 반환한다.")
    void isLastRoundWhenNotLastParameter() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);

        assertThat(gameAnswer.isLastRound(Round.valueOf(1))).isFalse();
    }
}
