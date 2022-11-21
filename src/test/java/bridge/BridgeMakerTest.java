package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리 생성 테스트")
    @Test
    void makingBridgeTest() {
        List<String> strings = bridgeMaker.makeBridge(10);
        Assertions.assertThat(strings.contains("U") || strings.contains("D")).isEqualTo(true);
    }
}
