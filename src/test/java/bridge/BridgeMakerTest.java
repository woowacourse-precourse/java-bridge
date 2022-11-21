package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest extends NsTest {
    @Test
    void makeTest() {
        assertRandomNumberInRangeTest(() -> run(),
                1, 0, 1,0);
//        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
//        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
//        List<String> bridge =bridgeMaker.makeBridge(5);
        assertThat(output()).isEqualTo("[U, D, U, D]");
    }

    @Test
    void makeUnder3() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void makeOver20() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Override
    protected void runMain() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge =bridgeMaker.makeBridge(4);
        System.out.print(bridge);
    }
}