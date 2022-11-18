package bridge.utils.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 다리_크기_통과() {
        Assertions.assertThatCode(() -> InputValidator.bridgeSizeValidate("3"))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_다리_크기_3미만() {
        Assertions.assertThatThrownBy(() -> InputValidator.bridgeSizeValidate("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_다리_크기_20초과() {
        Assertions.assertThatThrownBy(() -> InputValidator.bridgeSizeValidate("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_다리_크기_숫자가_아닌_입력() {
        Assertions.assertThatThrownBy(() -> InputValidator.bridgeSizeValidate("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_다리_크기_음수_입력() {
        Assertions.assertThatThrownBy(() -> InputValidator.bridgeSizeValidate("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 이동_통과() {
        Assertions.assertThatCode(() -> InputValidator.movingValidate("U"))
                .doesNotThrowAnyException();

        Assertions.assertThatCode(() -> InputValidator.movingValidate("D"))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_이동_U와D_이외의_입력() {
        Assertions.assertThatThrownBy(() -> InputValidator.movingValidate("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임재시작_통과() {
        Assertions.assertThatCode(() -> InputValidator.gameCommandValidate("R"))
                .doesNotThrowAnyException();

        Assertions.assertThatCode(() -> InputValidator.gameCommandValidate("Q"))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외_게임재시작_R과Q_이외의_입력() {
        Assertions.assertThatThrownBy(() -> InputValidator.gameCommandValidate("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}