package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {

    @Test
    void generate() {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();

        for (int i = 0; i < 5; i++) {
            System.out.println(generator.generate());
        }
    }
}