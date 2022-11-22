package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;




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
class BridgeRandomNumberGeneratorTest {

    @DisplayName("0과 1을 가져오는지 확인")
    @Test
    void generate_테스트() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> testRange = new ArrayList<>();
        for(int i=0; i<100; i++) {
            testRange.add(bridgeRandomNumberGenerator.generate());
        }
        Assertions.assertThat(testRange).containsOnly(1, 0);
    }
}