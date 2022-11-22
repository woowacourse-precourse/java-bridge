package bridge;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionCaseTest {

    @Test
    void isInputAllNumber_IllegalArgumentException_bridgeSizeLessThan3() {
        assertThatThrownBy(() -> ExceptionCase.isInputAllNumber("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isInputAllNumber_IllegalArgumentException_bridgeSizeMoreThan20() {
        assertThatThrownBy(() -> ExceptionCase.isInputAllNumber("50"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isInputTry_IllegalArgumentException_InputIsNotQW() {
        assertThatThrownBy(() -> ExceptionCase.isInputTry("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isInputUpOrDown_IllegalArgumentException_InputIsNotUD() {
        assertThatThrownBy(() -> ExceptionCase.isInputUpOrDown("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
