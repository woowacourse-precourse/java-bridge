package bridge.model;

import bridge.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    @DisplayName("다리 길이 입력값이 숫자가 아닐 경우 예외 발생")
    @ValueSource(strings = {"a", "1,2"})
    @ParameterizedTest
    void notNumber(String input) {
        assertThatThrownBy(() -> Validator.validateSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_NUMBER_POSSIBLE.getMessage());
    }

    @DisplayName("다리 길이 입력값이 허용 범위를 넘을 경우 예외 발생")
    @ValueSource(strings = {"1", "30", "-1"})
    @ParameterizedTest
    void outOfRange(String input) {
        assertThatThrownBy(() -> Validator.validateSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.OUT_OF_RANGE.getMessage());
    }
}
