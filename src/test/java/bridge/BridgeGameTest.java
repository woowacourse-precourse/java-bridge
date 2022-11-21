package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("사용자 입력에 다리가 있으면 O, 없으면 X")
    @Test
    void CheckUserMovementEqualBridge(){
        BridgeGame bridgeGame = new BridgeGame();

        String wrong = bridgeGame.moveEqualBridge("U","D");
        String right = bridgeGame.moveEqualBridge("U","U");
        assertEquals("O",right);
        assertEquals("X",wrong);
    }
}