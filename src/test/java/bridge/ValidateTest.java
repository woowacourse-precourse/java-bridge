package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidateTest {

    @Test
    void 다리_길이_숫자_아닌경우() {
        String length = "abc";
        assertThat(Validate.notNumeric(length)).isEqualTo(true);
    }

    @Test
    void 다리_길이_숫자인_경우() {
        String length = "123";
        assertThat(Validate.notNumeric(length)).isEqualTo(false);
    }

    @Test
    void 다리_길이_범위_초과() {
        String length = "123";
        assertThat(Validate.notInRange(length)).isEqualTo(true);
    }

    @Test
    void 다리_길이_유효_범위() {
        String length = "15";
        assertThat(Validate.notInRange(length)).isEqualTo(false);
    }
}
