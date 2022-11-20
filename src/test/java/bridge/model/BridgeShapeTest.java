package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BridgeShapeTest {

    @Test
    void 숫자에_해당하는_다리_모양() {
        assertThat(BridgeShape.getShapeFromRandomNumber(1)).isEqualTo("U");
    }
}
