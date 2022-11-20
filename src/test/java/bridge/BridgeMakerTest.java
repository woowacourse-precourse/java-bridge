package bridge;

import Constant.BridgeMakerConstant;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class BridgeMakerTest {
    @Test
    void isValidBridge() {
        assertSimpleTest(() -> {
            BridgeMaker maker = new BridgeMaker( new BridgeRandomNumberGenerator());
            maker.makeBridge(6);
        });
    }
}
