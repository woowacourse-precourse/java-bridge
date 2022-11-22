package bridge;

import org.junit.jupiter.api.Test;

import static bridge.View.Validator.InputValidator.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void validateInteger_NotInteger_IllegalArgumentException() {
        // 영어 문자
        assertThatThrownBy(() -> validateInteger("Z"))
                .isInstanceOf(IllegalArgumentException.class);
        //영어 문장
        assertThatThrownBy(() -> validateInteger("class"))
                .isInstanceOf(IllegalArgumentException.class);
        //특수 문자
        assertThatThrownBy(() -> validateInteger(";"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateInteger("*"))
                .isInstanceOf(IllegalArgumentException.class);
        // 엄청 큰 수
        assertThatThrownBy(() -> validateInteger("222665441154654564651231325464651231515615656156"))
                .isInstanceOf(IllegalArgumentException.class);
        // 영어 숫자 혼합
        assertThatThrownBy(() -> validateInteger("F112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRange_OutOfRange_IllegalArgumentException() {
        // 20보다 큰 수
        assertThatThrownBy(() -> validateRange(100))
                .isInstanceOf(IllegalArgumentException.class);
        // 3보다 작은 수
        assertThatThrownBy(() -> validateRange(-12))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateUpOrDown_NotUOrD_IllegalArgumentException() {
        // 다른 문자
        assertThatThrownBy(() -> validateUpOrDown("Z"))
                .isInstanceOf(IllegalArgumentException.class);
        // 숫자
        assertThatThrownBy(() -> validateUpOrDown("1111111"))
                .isInstanceOf(IllegalArgumentException.class);
        // 소문자
        assertThatThrownBy(() -> validateUpOrDown("u"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateUpOrDown("d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRetryOrQuit_NotROrQ_IllegalArgumentException() {
        // 다른 문자
        assertThatThrownBy(() -> validateUpOrDown("Z"))
                .isInstanceOf(IllegalArgumentException.class);
        // 숫자
        assertThatThrownBy(() -> validateUpOrDown("1111111"))
                .isInstanceOf(IllegalArgumentException.class);
        // 소문자
        assertThatThrownBy(() -> validateUpOrDown("q"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateUpOrDown("r"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}