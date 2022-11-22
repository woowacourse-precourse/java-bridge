package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeGameTest {
    @DisplayName("위의 다리랑 아래 다리가 정상적으로 O X로 들어가는지 테스트")
    @Test
    void upBridgeAndDownBridgeTest(){
        BridgeGame bridgeGame=new BridgeGame(List.of("U","D","U"));

        bridgeGame.move("U");
        assertThat(bridgeGame.getUpPresentBridge())
                .isEqualTo(List.of("O"));
        assertThat(bridgeGame.getDownPresentBridge())
                .isEqualTo(List.of("X"));

        bridgeGame.move("D");
        assertThat(bridgeGame.getUpPresentBridge())
                .isEqualTo(List.of("O","X"));
        assertThat(bridgeGame.getDownPresentBridge())
                .isEqualTo(List.of("X","O"));

        bridgeGame.move("U");
        assertThat(bridgeGame.getUpPresentBridge())
                .isEqualTo(List.of("O","X","O"));
        assertThat(bridgeGame.getDownPresentBridge())
                .isEqualTo(List.of("X","O","X"));
    }

}