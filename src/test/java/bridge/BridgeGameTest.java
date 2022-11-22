package bridge;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    public void stepForwardTest() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.stepForward(new ArrayList<>(), "U", "U");

    }
}