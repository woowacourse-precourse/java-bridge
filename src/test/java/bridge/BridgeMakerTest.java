package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeMakerTest {

    @DisplayName("다리 길이를 입력받았을 때 다리 모양 테스트")
    @ValueSource(ints = {3, 5, 10, 15, 20})
    @ParameterizedTest
    void makeBridgeTest(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertThat(bridge.size()).isEqualTo(size);
        for (String s : bridge) {
            Assertions.assertThat(s).isIn("U", "D");
        }
    }
}
