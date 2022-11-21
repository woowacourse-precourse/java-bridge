package bridge;

import bridge.constant.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @DisplayName("다리의 크기를 입력하면 만든 다리를 리스트로 반환한다.")
    @Test
    void createBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        for (int size = Bridge.MIN.getNumber(); size <= Bridge.MAX.getNumber(); size++) {
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.size()).isEqualTo(size);
        }
    }
}
