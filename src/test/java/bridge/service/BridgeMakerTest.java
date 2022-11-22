package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.mock.MockBridgeNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BridgeMakerTest {

    private int bridgeLength = 5;
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> createdBridge = bridgeMaker.makeBridge(bridgeLength);

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

    @DisplayName("숫자 0, 1에 각각 대응되는 D, U가 다리의 칸에 알맞게 생성되는지 확인한다.")
    @Test
    public void 숫자에_따른_다리의_U와_D_생성_확인() {
        List<Integer> bridgeNumbers = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(new MockBridgeNumberGenerator(bridgeNumbers));
        List<String> createdBridge = bridgeMaker.makeBridge(bridgeNumbers.size());

        Assertions.assertThat(createdBridge).containsOnly("U", "D", "U", "U", "D", "D", "U");
    }
}
