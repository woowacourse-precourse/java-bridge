package bridge.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {

    @DisplayName("입력받은 다리사이즈가 문자일때")
    @Test
    void 다리사이즈_입력시_숫자가_아닐때_예외테스트_1() {
        assertThatThrownBy(() -> Exception.checkIsNumberException("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 다리사이즈가 특수문자일때")
    @Test
    void 다리사이즈_입력시_숫자가_아닐때_예외테스트_2() {
        assertThatThrownBy(() -> Exception.checkIsNumberException("3*5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 다리사이즈가 음수일 때")
    @Test
    void 다리사이즈_입력시_숫자가_아닐때_예외테스트_3() {
        assertThatThrownBy(() -> Exception.checkIsNumberException("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 다리사이즈 범위 3보다 작을때 ")
    @Test
    void 다리사이즈_범위_테스트_1() {
        assertThatThrownBy(() -> Exception.checkRangeException("2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 다리사이즈 범위 20보다 클 때 ")
    @Test
    void 다리사이즈_범위_테스트_2() {
        assertThatThrownBy(() -> Exception.checkRangeException("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}