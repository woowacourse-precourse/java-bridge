package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    public static final String ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3 이상 20 이하입니다.";
    @Test
    void makeBridge_예외테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        for(int borderValue : Arrays.asList(2,21)){
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(borderValue));
            assertThat(bridge.sendDto().bridge).isNull();
        }
    }
}
