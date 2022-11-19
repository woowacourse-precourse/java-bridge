package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class bridgeMakeTest {

    @Test
    void 정상적으로_들어있는지(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Assertions.assertThat(bridgeMaker.makeBridge(5)).isNotEmpty();
    }
}
