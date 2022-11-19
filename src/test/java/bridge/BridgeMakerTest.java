package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @Test
    @DisplayName("다리 길이가 size와 같으면 성공이다.")
    void isBridgeSizeEqualToSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int testSize = 5;
        assertThat(bridgeMaker.makeBridge(testSize).size()).isEqualTo(testSize);
    }

    @Test
    @DisplayName("다리 길이가 범위 밖이면 오류를 던진다.")
    void makeBridgeOutOfRange() {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int testSize = 21;
        assertThatThrownBy(() -> bridgeMaker.makeBridge(testSize)).isInstanceOf(IllegalArgumentException.class);
    }
}