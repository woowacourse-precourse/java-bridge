package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    @Test
    void generate() {
        //given
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();

        //when
        int generate = generator.generate();

        //then
        Assertions.assertThat(generate == 1 || generate == 0).isEqualTo(true);
    }
}