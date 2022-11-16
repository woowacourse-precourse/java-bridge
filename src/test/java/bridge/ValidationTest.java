package bridge;

import static bridge.Message.ERROR_INVALID_BRIDGE_SIZE;
import static bridge.Validation.validateBridgeSize;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationTest {
    @ParameterizedTest
    @DisplayName("[ERROR] 적절하지 않은 값을 다리 사이즈로 입력시 예외 발생")
    @CsvSource({"1a2","21","2"})
    void invalidInputInBridgeSize(String userInput){
        assertThatThrownBy(()->validateBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_INVALID_BRIDGE_SIZE);
    }

}