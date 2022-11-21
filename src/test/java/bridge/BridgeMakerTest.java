package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @DisplayName("다리를 생성하는 지 확인한다.")
    @Test
    void makeBridge_테스트() {
        BridgeNumberGenerator numberGenerator
                = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("D", "U", "U", "D", "U");
    }
}