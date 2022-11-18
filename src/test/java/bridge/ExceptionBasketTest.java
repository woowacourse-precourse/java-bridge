package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ExceptionBasketTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("1~20이외의 숫자일 경우 예외 처리")
    void inputIsNotRangeExceptionTest(){
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotRangeException("5.0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotRangeException("5.3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotRangeException("+5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotRangeException("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotRangeException("05"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("허용된 숫자열이 아닐 시 예외 처리")
    void inputIsNotNumberExceptionTest(){
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotNumberException("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("게임 플레이중 잘못된 U, D이외를 누를경우 예외 처리")
    void invalidGameKeyTest(){
        assertThatThrownBy(() ->
                ExceptionBasket.invalidGameKey("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                ExceptionBasket.invalidGameKey("UU"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                ExceptionBasket.invalidGameKey("DD"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("다시 시작할지 말지 R, Q이외를 누를경우 예외 처리")
    void invalidRetryRequestInputKeyTest(){
        assertThatThrownBy(() ->
                ExceptionBasket.invalidRetryRequestInputKey("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                ExceptionBasket.invalidRetryRequestInputKey("RR"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                ExceptionBasket.invalidRetryRequestInputKey("QQ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
    /*@Test
    @DisplayName("허용되지 않은 숫자열 일 시 예외 처리")
    void invalidNumbericTest() {
        assertThatThrownBy(() ->
                ExceptionBasket.invalidNumberic("+5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                ExceptionBasket.invalidNumberic("-5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() ->
                ExceptionBasket.invalidNumberic("05"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }*/

}