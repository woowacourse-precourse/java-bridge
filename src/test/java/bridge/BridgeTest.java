package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    @Test
    void 정상작동(){
        Bridge bridge = new Bridge();
        bridge.setBridge(7);
        Assertions.assertThat(bridge.getBridge()).isNotEmpty();
    }
}
