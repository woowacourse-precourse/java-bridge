package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {
    @Test
    void generate_확인() {
        BridgeNumberGenerator test = new BridgeRandomNumberGenerator();
        System.out.println(test.generate());
    }
}