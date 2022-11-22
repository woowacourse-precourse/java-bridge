package bridge.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReadGameCommandValidationTest {
    private ReadGameCommandValidation readGameCommandValidation;

    @BeforeEach
    public void initialize() {
        readGameCommandValidation = new ReadGameCommandValidation();
    }

    @DisplayName("재시작, 종료 여부가 R 또는 Q로 입력되지 않은 경우, 예외가 발생한다.")
    @Test
    public void validateInputFormatTest() {
        assertThatThrownBy(() -> readGameCommandValidation.validateInputFormat("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
