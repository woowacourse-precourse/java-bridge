package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BridgeMakerTest {

    int bridgeLength = 5;
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> createdBridge = bridgeMaker.makeBridge(5);

    @DisplayName("주어진 길이와 생성된 다리의 길이는 동일해야 한다.")
    @Test
    public void 생성된_다리_길이_확인() {
        assertNotNull(createdBridge);
        Assertions.assertThat(createdBridge.size()).isEqualTo(bridgeLength);
    }

    @DisplayName("생성된 다리는 U 또는 D로만 이루어져 있다.")
    @Test
    public void 다리에_U와_D만_포함되는지_확인() {
        Assertions.assertThat(createdBridge).containsOnly("U", "D");
    }


}
