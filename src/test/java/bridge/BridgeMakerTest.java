package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;

    public BridgeMakerTest() {
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @DisplayName("입력 받은 수에 맞게 다리를 생성 한다.")
    @Test
    void makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(10);

        for (String cell : bridge) {
            Assertions.assertThat(cell == "U" || cell == "D").isTrue();
        }

        Assertions.assertThat(bridge.size()).isEqualTo(10);
    }

    @DisplayName("0, 1 을 위, 아래로 변환")
    @Test
    void convertNumberToString() {
        Assertions.assertThat(bridgeMaker.convertNumberToString(0)).isEqualTo("D");
        Assertions.assertThat(bridgeMaker.convertNumberToString(1)).isEqualTo("U");
    }
}