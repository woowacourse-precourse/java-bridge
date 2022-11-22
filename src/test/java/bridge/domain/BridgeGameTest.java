package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Answer;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(5));

    @DisplayName("잘못된 input 에러 테스트")
    @Test
    void 잘못된_input_에러_테스트(){
        assertThatThrownBy(() -> bridgeGame.move("이상한값"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동_테스트(String input){
        List<Answer> output = new LinkedList<>();
        output.add(Answer.CORRECT);
        output.add(Answer.INCORRECT);
        assertThat(output)
                .contains(bridgeGame.move(input));
    }
}
