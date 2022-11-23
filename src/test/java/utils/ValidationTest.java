package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    @DisplayName("3과 20 사이의 수를 입력하면 오류가 발생하지 않는다.")
    @Test
    void bridgeSize_테스트() {
        int input = 8;

        assertThatCode(() -> Validation.bridgeSize(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("3보다 작은 수를 입력하면 오류가 발생한다.")
    @Test
    void bridgeSize_예외_테스트1() {
        int input = 2;

        assertThatThrownBy(() -> Validation.bridgeSize(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("20보다 큰 수를 입력하면 오류가 발생한다.")
    @Test
    void bridgeSize_예외_테스트2() {
        int input = 21;

        assertThatThrownBy(() -> Validation.bridgeSize(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("U를 입력하면 오류가 발생하지 않는다.")
    @Test
    void moving_테스트1() {
        String input = "U";

        assertThatCode(() -> Validation.moving(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("U를 입력하면 오류가 발생하지 않는다.")
    @Test
    void moving_테스트2() {
        String input = "D";

        assertThatCode(() -> Validation.moving(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("문자열 U나 D가 아닌 수를 입력하면 오류가 발생한다.")
    @Test
    void moving_예외_테스트1() {
        String input = "G";

        assertThatThrownBy(() -> Validation.moving(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("문자열 U나 D가 아닌 수를 입력하면 오류가 발생한다.")
    @Test
    void moving_예외_테스트2() {
        String input = "UD";

        assertThatThrownBy(() -> Validation.moving(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("문자열 U나 D가 아닌 수를 입력하면 오류가 발생한다.")
    @Test
    void moving_예외_테스트3() {
        String input = "8";

        assertThatThrownBy(() -> Validation.moving(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("R을 입력하면 오류가 발생하지 않는다.")
    @Test
    void restart_테스트1() {
        String input = "R";

        assertThatCode(() -> Validation.restart(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("Q를 입력하면 오류가 발생하지 않는다.")
    @Test
    void restart_테스트2() {
        String input = "R";

        assertThatCode(() -> Validation.restart(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("문자열 R이나 Q가 아닌 수를 입력하면 오류가 발생한다.")
    @Test
    void restart_예외_테스트1() {
        String input = "U";
        assertThatThrownBy(() -> Validation.restart(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("문자열 R이나 Q가 아닌 수를 입력하면 오류가 발생한다.")
    @Test
    void restart_예외_테스트2() {
        String input = "RdflQ";

        assertThatThrownBy(() -> Validation.restart(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("문자열 R이나 Q가 아닌 수를 입력하면 오류가 발생한다.")
    @Test
    void restart_예외_테스트3() {
        String input = "1";

        assertThatThrownBy(() -> Validation.restart(input))
                .isInstanceOf(NoSuchElementException.class);
    }
}
