package bridge;

import bridge.controller.BridgeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest{

    BridgeGame makeBridgeGame(Integer ...elements)
    {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(elements));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return new BridgeGame(bridgeMaker.makeBridge(elements.length));
    }

    @Test
    void gameSuccessTest()
    {
        BridgeGame bridgeGame = makeBridgeGame(1,0,1,0,0);
        List<String> commands = List.of("U","D","U","D","D");

        for (String command : commands)
            Assertions.assertTrue(bridgeGame.move(command));

        String upper = "[ O |   | O |   |   ]\n";
        String lower = "[   | O |   | O | O ]\n";
        Assertions.assertEquals(bridgeGame.getBridgeMap(),upper+lower);
    }

    @Test
    void moveFailTest()
    {
        BridgeGame bridgeGame = makeBridgeGame(1,0,1,0,0);
        Assertions.assertFalse(bridgeGame.move("D"));

        String upper = "[   ]\n";
        String lower = "[ X ]\n";
        Assertions.assertEquals(bridgeGame.getBridgeMap(),upper+lower);
    }

    @Test
    void moveFailAndRetryTest()
    {
        BridgeGame bridgeGame = makeBridgeGame(0,1,1,0,1);

        Assertions.assertTrue(bridgeGame.move("D"));
        Assertions.assertFalse(bridgeGame.move("D"));

        Assertions.assertEquals(bridgeGame.getBridgeMap(),String.join("","[   |   ]\n","[ O | X ]\n"));
        bridgeGame.retry();
        Assertions.assertEquals(bridgeGame.getBridgeMap(),String.join("","[   ]\n","[ O ]\n"));
    }

}
