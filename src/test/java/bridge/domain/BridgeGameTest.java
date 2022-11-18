package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    @DisplayName("잘못된 input 에러 테스트")
    @Test
    void 잘못된_input_에러_테스트(){
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(5));
        assertThatThrownBy(() -> bridgeGame.move("이상한값"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
