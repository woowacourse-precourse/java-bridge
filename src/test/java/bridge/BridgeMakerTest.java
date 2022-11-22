package bridge;

import static bridge.enums.BridgeConstants.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {

    @DisplayName("다리 생성 테스트")
    @Test
    void makeBridgeTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size()).isEqualTo(3);
        assertThat(bridge.contains(UPSIDE.getValue()) || bridge.contains(DOWNSIDE.getValue())).isTrue();
    }
}
