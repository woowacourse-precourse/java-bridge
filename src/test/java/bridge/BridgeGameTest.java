package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void makeBridge() {
    }

    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame();
        /*given*/
        String moveTest = "[U]";
        /*when*/
        String moveActual = bridgeGame.move(List.of("U","U"),0,"U");
        /*then*/
    }

    @Test
    void retry() {
    }
}