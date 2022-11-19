package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    @DisplayName("다리 길이를 입력할 때 숫자가 아니라면 예외 처리")
    @ValueSource(strings = {"dksehla", "d", "안돼", "@#"})
    @ParameterizedTest
    void onlyNumberBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이를 입력할 때 3미만이면 예외 처리")
    @ValueSource(strings = {"2", "-1", "2.5", "1"})
    @ParameterizedTest
    void minBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이를 입력할 때 20이상이라면 예외 처리")
    @ValueSource(strings = {"21", "50", "80", "100000"})
    @ParameterizedTest
    void maxBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이를 입력할 때 올바른 값 입력하면 int형으로 반환한다.")
    @ValueSource(strings = {"14", "3", "7", "19"})
    @ParameterizedTest
    void correctBridgeSize(String bridgeSize) {
        int size = InputValidator.checkBridgeSize(bridgeSize);
        assertThat(size).isEqualTo(Integer.parseInt(bridgeSize));
    }
}
