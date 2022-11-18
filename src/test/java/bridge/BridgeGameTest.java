package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("다리 상태가 제대로 만들어졌는지 확인")
    @Test
    void createBridgePrintFormatTest(){
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","D","U"));
        bridgeGame.move("U");
        assertThat(bridgeGame.createBridgePrintFormat()).containsExactly("[ O ]","[   ]");
        bridgeGame.move("D");
        assertThat(bridgeGame.createBridgePrintFormat()).containsExactly("[ O |   ]","[   | O ]");
        bridgeGame.move("D");
        assertThat(bridgeGame.createBridgePrintFormat()).containsExactly("[ O |   |   ]","[   | O | O ]");
        bridgeGame.move("D");
        assertThat(bridgeGame.createBridgePrintFormat()).containsExactly("[ O |   |   |   ]","[   | O | O | X ]");
    }
}
