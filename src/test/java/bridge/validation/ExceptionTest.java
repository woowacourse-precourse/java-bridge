package bridge.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {

    @DisplayName("입력받은 다리사이즈가 올바른 숫자인지에 대한 테스트")
    @ValueSource(strings = {"abc", "3*5", "-5"})
    @ParameterizedTest
    void 다리가_올바른_숫자인지_테스트(String input) {
        assertThatThrownBy(() -> Exception.checkIsNumberException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 다리사이즈가 올바른 숫자인지에 대한 테스트")
    @ValueSource(strings = {"2", "21", "0"})
    @ParameterizedTest
    void 다리가_범위안에_들어오는지_테스트(String input) {
        assertThatThrownBy(() -> Exception.checkRangeException(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 이동할 칸이 올바른 문자인지에 대한 테스트")
    @ValueSource(strings = {"u", "A", "0", "3", "UU", "ABBD"})
    @ParameterizedTest
    void 이동할_칸이_올바른_문자인지_테스트(String input) {
        assertThatThrownBy(() -> Exception.checkCorrectInputUpDown(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 재시작 여부 값이 올바른 문자인지에 대한 테스트")
    @ValueSource(strings = {"u", "A", "0", "3", "UU", "ABBD"})
    @ParameterizedTest
    void 재시작_여부_값이_올바른_문자인지_테스트(String input) {
        assertThatThrownBy(() -> Exception.checkCorrectInputQuitRestart(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}