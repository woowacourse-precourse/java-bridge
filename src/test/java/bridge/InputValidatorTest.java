package bridge;

import org.junit.jupiter.api.Test;

import static bridge.Validator.InputValidator.validateInteger;
import static bridge.Validator.InputValidator.validateRange;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void validateNumeric_NotNumeric_IllegalArgumentException() {
        // 영어 대문자
        assertThatThrownBy(() -> validateInteger("Z"))
                .isInstanceOf(IllegalArgumentException.class);
        //영어 소문자
        assertThatThrownBy(() -> validateInteger("class"))
                .isInstanceOf(IllegalArgumentException.class);
        //특수문자
        assertThatThrownBy(() -> validateInteger(";"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateInteger("*"))
                .isInstanceOf(IllegalArgumentException.class);
        // 영어 숫자 혼합
        assertThatThrownBy(() -> validateInteger("F112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRange_OutOfRange_IllegalArgumentException() {
        // 엄청 큰 수
        assertThatThrownBy(() -> validateInteger("222665441154654564651231325464651231515615656156"))
                .isInstanceOf(IllegalArgumentException.class);
        // 20보다 큰 수
        assertThatThrownBy(() -> validateRange(100))
                .isInstanceOf(IllegalArgumentException.class);
        // 3보다 작은 수
        assertThatThrownBy(() -> validateRange(-12))
                .isInstanceOf(IllegalArgumentException.class);


    }
}
