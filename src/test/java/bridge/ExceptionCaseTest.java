package bridge;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionCaseTest {

    @Test
    void bridge_size가_3보다_작은_경우() {
        assertThatThrownBy(() -> ExceptionCase.isInputAllNumber("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bridge_size가_20보다_큰_경우() {
        assertThatThrownBy(() -> ExceptionCase.isInputAllNumber("50"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void R_Q_이외의_값이_들어오는_경우() {
        assertThatThrownBy(() -> ExceptionCase.isInputTry("W"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
