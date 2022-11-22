package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 이동_성공_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<String>(Arrays.asList("U","U")));
        bridgeGame.move("U");
        bridgeGame.move("U");
    }
    @Test
    void 이동_실패_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<String>(Arrays.asList("U","U")));
        bridgeGame.move("U");
        bridgeGame.move("D");
    }
}