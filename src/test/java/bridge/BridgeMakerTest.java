package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    @DisplayName("올바른 브릿지(랜덤) 리스트가 생성되는가")
    @Test
    void makeCorrectBridge() {
        List<String> bridgeString = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(3);

        // bridgeString 에 D 와 U 가 모두 포함되어있을 때
        if (bridgeString.contains("U") && bridgeString.contains("D")) {
            // 리스트 사이즈가 3이고 D 와 U 모두를 포함하는가
            assertThat(bridgeString).hasSize(3).contains("U", "D");
        // bridgeString 에 D 만 포함되어 있을 때
        } else if (!bridgeString.contains("U")) {
            // 리스트 사이즈가 3이고 D 만을 포함하는가
            assertThat(bridgeString).hasSize(3).contains("D");
        // bridgeString 에 U 만 포함되어 있을 때
        } else if (!bridgeString.contains("D")) {
            // 리스트 사이즈가 3이고 U 만을 포함하는가
            assertThat(bridgeString).hasSize(3).contains("U");
        }
    }
}