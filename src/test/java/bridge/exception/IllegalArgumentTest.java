package bridge.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IllegalArgumentTest {

    @Test
    void 숫자가_아닌_입력값() {
        assertThat(IllegalArgument.isNotNumber("숫자아님")).isTrue();
    }

    @Test
    void 숫자인_입력값() {
        assertThat(IllegalArgument.isNotNumber("3")).isFalse();
    }
}
