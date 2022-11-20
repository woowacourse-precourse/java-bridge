package bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker (bridgeNumberGenerator);

    @Test
    void addNumberWhenInputIsZeroTest() {
        List<String> crossable = new ArrayList<>();
        List<String> result = List.of("D");

        bridgeMaker.addNumber(crossable,0);

        assertEquals(result,crossable);
    }

    @Test
    void addNumberWhenInputIsOneTest() {
        List<String> crossable = new ArrayList<>();
        List<String> result = List.of("U");

        bridgeMaker.addNumber(crossable,1);

        assertEquals(result,crossable);
    }

    @Test
    void makeBridgeTest() {
        List<String> crossable = bridgeMaker.makeBridge(5);
        int result = 5;

        assertEquals(result,crossable.size());
    }
}