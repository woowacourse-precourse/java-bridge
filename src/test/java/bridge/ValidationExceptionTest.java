package bridge;

import bridge.constants.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;


class ValidationExceptionTest {

    ValidationException validationException;

    @BeforeEach
    void beforeEach() {
        validationException = new ValidationException();
    }

    @Test
    @DisplayName("올바른 값 통과 확인")
    void testValidNumber() {
        Assertions.assertThat(validationException.checkValidNumber("20")).isEqualTo(true);
    }

    @Test
    @DisplayName("잘못된 값 에러 확인")
    void testInvalidNumber() {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> validationException.checkValidNumber("가나"));
    }
}