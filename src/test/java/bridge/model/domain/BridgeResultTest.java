package bridge.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.model.constnce.Text.FAIL;
import static bridge.model.constnce.Text.SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

class BridgeResultTest {
    @DisplayName("init 확인")
    @Test
    void initTest(){
        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.init();

        assertEquals(SUCCESS, bridgeResult.getResult());
        assertTrue(bridgeResult.getIsClear());
    }

    @DisplayName("failedRound 값 변경 확인")
    @Test
    void failedRoundTest(){
        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.failedRound();

        assertFalse(bridgeResult.getIsClear());
    }

    @DisplayName("failedGame 값 변경 확인")
    @Test
    void failedGameTest(){
        BridgeResult bridgeResult = new BridgeResult();
        bridgeResult.failedGame();

        assertEquals(FAIL, bridgeResult.getResult());
    }
}