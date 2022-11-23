package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakeTest extends  NsTest{

    private static BridgeMaker bridgeMaker;
    @BeforeAll
    static void initialize(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @Test
    void testMakeWood(){
        assertThat(bridgeMaker.makeWood(0)).isEqualTo("D");
        assertThat(bridgeMaker.makeWood(1)).isEqualTo("U");
    }
    @Test
    void testMakeBridge(){
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size()).isEqualTo(3);
        assertThat(bridge).contains("U", "D");
    }
    @Override
    protected void runMain() {
    }

}
