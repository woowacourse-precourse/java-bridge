package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Model.Map;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BridgeGameTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame();
    List<String> crossable = bridgeMaker.makeBridge(5);

    @Test
    void moveWhenMovingEqualsAnswerTest() {
        Map map = new Map(crossable);
        String moving = crossable.get(0);
        boolean result = true;

        assertEquals(result,bridgeGame.move(map,0,moving));
    }

    private String getUnequalCrossableValue(String value) {
        if (value.equals("U")) {
            return "D";
        }
        return "U";
    }

    @Test
    void moveWhenMovingUnequalsAnswerTest() {
        Map map = new Map(crossable);
        String moving = getUnequalCrossableValue(crossable.get(0));
        boolean result = false;

        assertEquals(result,bridgeGame.move(map,0,moving));
    }

    @Test
    void retryTest() {
        Map map = new Map(crossable);
        List<String> mapResult = List.of("[");
        int attempts = 0;
        int attemptsResult = 1;

        assertEquals(attemptsResult,bridgeGame.retry(map,attempts));
        assertEquals(mapResult,map.getMapLower());
        assertEquals(mapResult,map.getMapUpper());
    }

}

