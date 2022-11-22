package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest extends NsTest {

    @DisplayName("랜덤한 다리를 생성한다.")
    @Test
    public void testGeneratingBridge(){
        assertRandomNumberInRangeTest(() -> {
            run();
            BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = maker.makeBridge(3);
            assertTrue(bridge.equals(List.of("U", "D", "U")));
        }, 1, 0, 1);
    }


    @Override
    protected void runMain() {

    }
}