package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    @DisplayName("다리 길이가 3미만 일 경우 예외 처리한다.")
    @Test
    void bridgeSizeLessThanThree() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 20초과 일 경우 예외 처리한다.")
    @Test
    void bridgeSizeGreaterThanTwenty() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3이상 20이하 일 경우 정상 처리한다.")
    @Test
    void bridgeSizeValidRange() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(20).size()).isEqualTo(20);
    }
}
