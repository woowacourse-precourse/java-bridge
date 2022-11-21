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

    @Test
    void 이동_방향_올바르지_않은_입력() {
        String direction = "T";
        assertThat(Validate.invalidDirection(direction)).isEqualTo(true);
    }

    @Test
    void 이동_방향_올바른_입력() {
        String direction = "U";
        String direction1 = "D";
        assertThat(Validate.invalidDirection(direction)).isEqualTo(false);
        assertThat(Validate.invalidDirection(direction1)).isEqualTo(false);
    }

    @Test
    void 재시작_코드_올바르지_않은_입력() {
        String code = "B";
        assertThat(Validate.invalidRestartCode(code)).isEqualTo(true);
    }

    @Test
    void 재시작_코드_올바른_입력() {
        String quit = "Q";
        String restart = "Q";
        assertThat(Validate.invalidRestartCode(quit)).isEqualTo(false);
        assertThat(Validate.invalidRestartCode(restart)).isEqualTo(false);
    }
}
