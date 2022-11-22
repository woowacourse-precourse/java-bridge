package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.*;

public class BridgeMakerTest {
    @DisplayName("길이가 3인 다리를 생성하는 메서드를 호출하면 그 결과로 길이가 3인 다리가 생성되어야 한다.")
    @Test
    void makeBridgeSize3ToSuccessful() {
        BridgeNumberGenerator generator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size() == 3);
        assertThat(bridge).containsExactly("D", "U", "U");
    }
}


