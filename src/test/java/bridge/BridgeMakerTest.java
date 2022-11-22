package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Test
    public void numberToBridgeTest() {
        List<Integer> numbers = List.of(0, 0, 1, 1, 1);
        List<String> bridge = List.of("D", "D", "U", "U", "U");

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertEquals(bridgeMaker.numberToBridge(numbers), bridge);
    }


}