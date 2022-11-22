package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.service.BridgeGame;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    void successAllTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        BridgeMap bridgeMap = new BridgeMap(bridge,
                List.of(Direction.UP, Direction.DOWN, Direction.UP, Direction.DOWN));
        String answer = "[ O |   | O |   ]\n"
                + "[   | O |   | O ]\n";
        Assertions.assertEquals(bridgeMap.toString(), answer);
    }

    @Test
    void failTest() {
        Bridge bridge = new Bridge(List.of("U", "D", "U", "D"));
        BridgeMap bridgeMap = new BridgeMap(bridge,
                List.of(Direction.UP, Direction.DOWN, Direction.DOWN));
        String answer = "[ O |   |   ]\n"
                + "[   | O | X ]\n";
        Assertions.assertEquals(bridgeMap.toString(), answer);
    }

    @Test
    void moveTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        Assertions.assertTrue(bridgeGame.move(Direction.DOWN));
        Assertions.assertFalse(bridgeGame.move(Direction.UP));
        Assertions.assertTrue(bridgeGame.move(Direction.DOWN));
        Assertions.assertTrue(bridgeGame.move(Direction.DOWN));
    }

    @Test
    void clearTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        bridgeGame.move(Direction.DOWN);
        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);
        Assertions.assertFalse(bridgeGame.isCleared());
        bridgeGame.move(Direction.DOWN);
        Assertions.assertTrue(bridgeGame.isCleared());
    }

    @Test
    void restartTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(0, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
        bridgeGame.move(Direction.UP);
        bridgeGame.retry(Command.Retry);
        Assertions.assertEquals(2, bridgeGame.getTryCount());
    }

}
