package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리 사이즈가 3이상 20 이하가 아닌 경우 예외가 발생한다")
    @Test
    void createBridgeByOverSize() {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 사이즈가 3이상 20 이하가 아닌 경우 예외가 발생한다")
    @Test
    void createBridgeByUnderSize() {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
