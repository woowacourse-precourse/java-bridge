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

    @Test
    void 다리의_길이_범위_밖_입력값() {
        assertThat(IllegalArgument.isNotInBridgeSizeRange("24")).isTrue();
    }

    @Test
    void 다리의_길이_범위_안_입력값() {
        assertThat(IllegalArgument.isNotInBridgeSizeRange("20")).isFalse();
    }
}
