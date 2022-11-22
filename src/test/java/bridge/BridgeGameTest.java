package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 움직임_테스트() {
        //GIVEN
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","D"));
        //WHEN
        BirdgeMoveType moveCheck = bridgeGame.move("U");
        //THEN
        assertEquals(moveCheck,BirdgeMoveType.upGoMovement);
    }
    @Test
    void 움직임_테스트_실패() {
        //GIVEN
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","D"));
        //WHEN
        BirdgeMoveType moveCheck = bridgeGame.move("D");
        //THEN
        assertEquals(moveCheck,BirdgeMoveType.downStopMovement);
    }

}