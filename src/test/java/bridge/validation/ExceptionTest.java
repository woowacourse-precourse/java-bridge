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

    @DisplayName("입력받은 다리사이즈 범위 3보다 작을때")
    @Test
    void 다리사이즈_범위_테스트_1() {
        assertThatThrownBy(() -> Exception.checkRangeException("2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 다리사이즈 범위 20보다 클 때")
    @Test
    void 다리사이즈_범위_테스트_2() {
        assertThatThrownBy(() -> Exception.checkRangeException("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 이동할 칸이 소문자 u 일경우")
    @Test
    void 이동할칸_테스트_1() {
        assertThatThrownBy(() -> Exception.checkCorrectInputUpDown("u"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 이동할 칸이 다른 문자 일경우")
    @Test
    void 이동할칸_테스트_2() {
        assertThatThrownBy(() -> Exception.checkCorrectInputUpDown("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 이동할 칸이 숫자일 경우")
    @Test
    void 이동할칸_테스트_3() {
        assertThatThrownBy(() -> Exception.checkCorrectInputUpDown("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 이동할 칸이 여러문자일 경우")
    @Test
    void 이동할칸_테스트_4() {
        assertThatThrownBy(() -> Exception.checkCorrectInputUpDown("UU"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 재시작 여부 값이 소문자 q 일경우")
    @Test
    void 게임종료_입력_테스트_1() {
        assertThatThrownBy(() -> Exception.checkCorrectInputQuitRestart("u"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 재시작 여부 값이 다른 문자 일경우")
    @Test
    void 게임종료_입력_테스트_2() {
        assertThatThrownBy(() -> Exception.checkCorrectInputQuitRestart("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 재시작 여부 값이 숫자일 경우")
    @Test
    void 게임종료_입력_테스트_3() {
        assertThatThrownBy(() -> Exception.checkCorrectInputQuitRestart("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력받은 재시작 여부 값이 여러문자일 경우")
    @Test
    void 게임종료_입력_테스트_4() {
        assertThatThrownBy(() -> Exception.checkCorrectInputQuitRestart("RR"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}