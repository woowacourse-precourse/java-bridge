package bridge;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionCaseTest {

    @Test
    void bridge_size가_3보다_작은_경우() {
        assertThatThrownBy(() -> ExceptionCase.isInputAllNumber("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
