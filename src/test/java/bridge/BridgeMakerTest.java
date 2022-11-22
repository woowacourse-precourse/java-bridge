package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;


class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    List<String> bridge =  bridgeMaker.makeBridge(3);

    @Test
    void 입력한_크기의_다리를_생성하는지_확인() {
        Assertions.assertThat(bridge.size()).isEqualTo(3);
    }

    @Test
    void 다리가_U와_D만을_가지는지_확인() {
        Assertions.assertThat(bridge).containsOnly("U", "D");

    }

}