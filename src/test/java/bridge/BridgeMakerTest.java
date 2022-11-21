package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class BridgeMakerTest {

    private static BridgeRandomNumberGenerator BRIDGE_RANDOM_NUMBER_GENERATOR;
    private static BridgeMaker BRIDGE_MAKER;
    @BeforeEach
    void setUp() {
        BRIDGE_RANDOM_NUMBER_GENERATOR= new BridgeRandomNumberGenerator();
        BRIDGE_MAKER = new BridgeMaker(BRIDGE_RANDOM_NUMBER_GENERATOR);
    }

}