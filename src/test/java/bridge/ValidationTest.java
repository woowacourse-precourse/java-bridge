package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {
    Validation validation = new Validation();

    @Test
    @DisplayName("다리 길이 범위 검증")
    void bridgeSizeValidation_fault1() {
        Assertions.assertThatThrownBy(() ->
                validation.validationNumber(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 길이 범위 검증")
    void bridgeSizeValidation_fault2() {
        Assertions.assertThatThrownBy(() ->
                        validation.validationNumber(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
