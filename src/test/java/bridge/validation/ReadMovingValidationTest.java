package bridge.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReadMovingValidationTest {
    private ReadMovingValidation readMovingValidation;

    @BeforeEach
    public void initialize() {
        readMovingValidation = new ReadMovingValidation();
    }

    @DisplayName("이동할 칸이 D 또는 U로 입력되지 않은 경우, 예외가 발생한다.")
    @Test
    public void validateInputFormatTest() {
        assertThatThrownBy(() -> readMovingValidation.validateInputFormat("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
