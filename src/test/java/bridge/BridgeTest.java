package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BridgeTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    @DisplayName("size에 맞게 List를 생성한다.")
    @Test
    public void bridgeMakerTest1() {
        int num = 5;

        Assertions.assertThat(bridgeMaker.makeBridge(num).size()).isEqualTo(num);
    }
}