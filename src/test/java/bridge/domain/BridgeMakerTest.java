package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

public class BridgeMakerTest {
    BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

    @RepeatedTest(30)
    void 생성된_다리가_U이나_D로만_이루어져_있는_지_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).contains("U", "D");
    }

    @RepeatedTest(30)
    void 다리가_정해진_사이즈로_생성되는_지_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(10);
        assertThat(bridge).hasSize(10);
    }
}
