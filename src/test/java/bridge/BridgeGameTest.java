package bridge;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {
    @DisplayName("이동할 수 있을 때 true를 반환한다.")
    @Test
    void createMovable() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("U", "U");
        assertTrue(move);
    }

    @DisplayName("이동할 수 없을 때 false를 반환한다.")
    @Test
    void createUnMovable() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean move = bridgeGame.move("D", "U");
        assertFalse(move);
    }

    @DisplayName("이동 성공했을떄 올바른 브릿지 상태를 그린다.")
    @Test
    void createMoveSuccessBridge() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean moveOne = bridgeGame.move("U", "U");
        boolean moveTwo = bridgeGame.move("D", "D");
        boolean moveThree = bridgeGame.move("D", "D");
        assertThat(bridgeGame.getHighBridge()).isEqualTo(List.of("O", " ", " "));
        assertThat(bridgeGame.getLowBridge()).isEqualTo(List.of(" ", "O", "O"));
    }

    @DisplayName("이동 실패했을떄 올바른 브릿지 상태를 그린다.")
    @Test
    void createMoveFailureBridge() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean moveOne = bridgeGame.move("D", "D");
        boolean moveTwo = bridgeGame.move("D", "D");
        boolean moveThree = bridgeGame.move("U", "D");
        assertThat(bridgeGame.getHighBridge()).isEqualTo(List.of(" ", " ", "X"));
        assertThat(bridgeGame.getLowBridge()).isEqualTo(List.of("O", "O", " "));
    }
}
