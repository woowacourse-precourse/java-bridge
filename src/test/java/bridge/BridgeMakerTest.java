package bridge;

import bridge.exception.InputException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {
    @DisplayName("입력한 길이만큼 다리가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }

    @DisplayName("입력한 길이가 숫자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "a", "ab"})
    void generateBridgeSizeTypeException(String bridgeSize) {
        assertThatThrownBy(() -> InputException.isValidBridgeSizeType(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 길이가 3이상 20이하의 범위에 포함되지 않는다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21"})
    void generateBridgeSizeRangeException(String bridgeSize) {
        assertThatThrownBy(() -> InputException.isValidBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}