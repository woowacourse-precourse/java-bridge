package bridge;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void 다리생성후_다리가_U_D로_이루어져있는지_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(5);
        for (String step : bridge) {
            assertThat(step.matches("[UD]")).isEqualTo(true);
        }
    }

    @Test
    void 만들고자_하는_다리의_크기가_맞는지_테스트(){
        List<String> bridge = bridgeMaker.makeBridge(7);
        assertThat(bridge.size()).isEqualTo(7);
    }
}
