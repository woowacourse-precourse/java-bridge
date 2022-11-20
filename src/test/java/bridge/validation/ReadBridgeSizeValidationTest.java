package bridge.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ReadBridgeSizeValidationTest {
    private ReadBridgeSizeValidation readBridgeSizeValidation;

    @BeforeEach
    public void initialize() {
        readBridgeSizeValidation = new ReadBridgeSizeValidation();
    }

    @DisplayName("다리 길이 입력 시 숫자가 아닌 문자가 입력될 경우, 예외가 발생한다.")
    @Test
    public void validateInputIsIntegerTest() {
        assertThatThrownBy(() -> readBridgeSizeValidation.validateInputIsInteger("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3보다 작거나 20보다 큰 경우, 예외가 발생한다.")
    @Test
    public void validateSizeRangeTest() {
        assertThatThrownBy(() -> readBridgeSizeValidation.validateSizeRange("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
