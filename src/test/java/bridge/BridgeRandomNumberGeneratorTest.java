package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    @BeforeEach
    void init() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @Test
    void generate_mustGenerate0or1() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int number = bridgeRandomNumberGenerator.generate();
            result.add(number);
        }

        assertThat(result.size()).isEqualTo(10);
        assertThat(result).allMatch(number -> 0 <= number && number <= 1);
    }
}