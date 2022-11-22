package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @DisplayName("입력받은 길이의 다리를 생성하는지 확인")
    @Test
    void sizeOfBridge() {
        List<String> bridge = bridgeMaker.makeBridge(5); //길이가 5인 다리 생성

        Assertions.assertThat(bridge.size()).isEqualTo(5);
    }

    @DisplayName("U나 D를 제외한 문자열이 들어가 있는지 확인")
    @Test
    void notContainOtherThenUorD() {
        List<String> bridge = bridgeMaker.makeBridge(20);

        Assertions.assertThat(bridge).doesNotContain("[^UD]");
    }
}
