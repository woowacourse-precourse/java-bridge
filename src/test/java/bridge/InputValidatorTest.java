package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.InputValidationError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("다리 길이 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void validateBridgeSizeTestIllegalArgumentException(int size) {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateBridgeSize(size)).isEqualTo(
                InputValidationError.ERROR_BRIDGE_SIZE.exception
        );
    }

    @DisplayName("다리 길이 정상 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void validateBridgeSizeTestPass(int size) {
        InputValidator validator = new InputValidator();
        validator.validateBridgeSize(size);
    }
}
