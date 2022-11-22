package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;


class BridgeRandomNumberGeneratorTest {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    @Test
    void generate() {
        /*given*/
        List<Integer> generatorTest = List.of(0, 1);

        /*when*/
        int generator = bridgeRandomNumberGenerator.generate();

        /*then*/
        assertThat(generator).isIn(generatorTest);
    }
}