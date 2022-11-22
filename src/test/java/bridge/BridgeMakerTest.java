package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @DisplayName("생성된 다리가 U와 D만으로 이뤄졌는지와 길이를 확인한다.")
    @RepeatedTest(10)
    void TestMakingBridge() {
        int size = 20;
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        assertThat(bridge)
                .containsOnly("U", "D")
                .hasSize(size);
    }
}
