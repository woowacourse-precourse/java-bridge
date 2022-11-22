package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("입력받은 길이에 해당하는 다리 모양. 위 칸이면 U, 아래 칸이면 D로 표현하는 다리의 생성 테스트")
    @Test
    void makeBridge_onlyTwoAlphaBat() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(6);

        assertThat(bridge).containsOnly("U", "D");
    }

    @DisplayName("입력받은 길이에 해당하는 다리 모양. 위 칸이면 U, 아래 칸이면 D로 표현하는 다리의 다른 문자가 포함되지 않는지 생성하는 테스트")
    @Test
    void makeBridgeCheckOtherAlphaBat() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(6);

        assertThat(bridge).doesNotContain("A", "B", "C");
    }

}