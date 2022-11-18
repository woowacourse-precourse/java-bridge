package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    @DisplayName("다리 길이 입력에서 숫자가 아닌 것을 입력할 경우")
    @ParameterizedTest
    @CsvSource({"U","UD"})
    void validate_notNum(String notNum) {
        assertThatThrownBy(() -> Validation.validateBridgeSize(notNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력에서 3 미만 테스트")
    @Test
    void validate_under3() {
        assertThatThrownBy(() -> Validation.validateBridgeSize("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력에서 20 초과 테스트")
    @Test
    void validate_over20() {
        assertThatThrownBy(() -> Validation.validateBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 위치 입력 예외 테스트")
    @ParameterizedTest
    @CsvSource({"a","A","에이","1","UD"})
    void validate_notUOrD(String userInput) {
        assertThatThrownBy(() -> Validation.validateMovingChoice(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}