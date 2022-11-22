package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("생성된 다리 번호 중 0과 1이 아닌 수가 있으면 IllegalStateException이 발생한다")
    @Test
    void makeBridgeByInvalidBridgeNumbers() {
        bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(2, 0, 0)));
        assertThatThrownBy(() -> bridgeMaker.makeBridge(3))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("생성된 다리 번호가 0이나 1뿐이면 정상적으로 생성된다.")
    @Test
    void makeBridgeByValidBridgeNumbers() {
        bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        assertThatCode(() -> bridgeMaker.makeBridge(3))
                .doesNotThrowAnyException();
    }
}
