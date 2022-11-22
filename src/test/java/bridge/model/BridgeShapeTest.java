package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.util.Constants.Constant;
import org.junit.jupiter.api.Test;

public class BridgeShapeTest {

    @Test
    void 숫자_1에_해당하는_다리_모양() {
        assertThat(BridgeShape.getShapeFromRandomNumber(1)).isEqualTo(Constant.UPSIDE);
    }

    @Test
    void 숫자_0에_해당하는_다리_모양() {
        assertThat(BridgeShape.getShapeFromRandomNumber(0)).isEqualTo(Constant.DOWN);
    }
}
