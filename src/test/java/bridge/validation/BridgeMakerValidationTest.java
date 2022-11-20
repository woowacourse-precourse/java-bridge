package bridge.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMakerValidationTest {
    private BridgeMakerValidation bridgeMakerValidation;

    @BeforeEach
    public void initialize() {
        bridgeMakerValidation = new BridgeMakerValidation();
    }

    @DisplayName("생성된 랜덤값이 0 또는 1이 아닌 경우, 예외가 발생한다.")
    @Test
    public void validateGeneratedNumValueTest() {
        assertThatThrownBy(() -> bridgeMakerValidation.validateGeneratedNumValue(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
