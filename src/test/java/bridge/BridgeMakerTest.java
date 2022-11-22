package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    @Test
    @DisplayName("생성된 다리의 길이는 입력한 숫자와 같다.")
    void makeBridge_MakeBridgeByNumber_SizeIsSameAsNumber() {
        int number = 5;
        List<String> bridge = bridgeMaker.makeBridge(number);
        assertThat(bridge).hasSize(number);
    }
}