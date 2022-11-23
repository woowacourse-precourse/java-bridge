package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommonTest {

    @DisplayName("문자열 값을 입력하면 숫자로 변환한다.")
    @Test
    void convertInputToNumber_테스트1() {
        String input = "5";
        int result = 5;

        assertThat(result).isEqualTo(Common.convertInputToNumber(input));
    }

    @DisplayName("입력 값에 숫자가 아닌 문자가 포함되면 오류가 발생한다.")
    @Test
    void convertInputToNumber_예외_테스트1() {
        String input = "5a";

        assertThatThrownBy(() -> Common.convertInputToNumber(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("입력 값에 숫자가 아닌 문자가 포함되면 오류가 발생한다.")
    @Test
    void convertInputToNumber_예외_테스트2() {
        String input = "5 0";

        assertThatThrownBy(() -> Common.convertInputToNumber(input))
                .isInstanceOf(NoSuchElementException.class);
    }
}
