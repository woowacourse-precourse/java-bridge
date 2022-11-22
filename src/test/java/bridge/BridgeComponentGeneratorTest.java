package bridge;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeComponentGeneratorTest {
    @Test
    void BridgeComponentGeneratorTest() {
        BridgeComponentGenerator Bridge_generator =  new BridgeComponentGenerator();

        String out = Bridge_generator.generate(1);
        assertThat(out).isEqualTo("U");
    }
}
