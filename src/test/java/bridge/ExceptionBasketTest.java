package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionBasketTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("1~20이외의 숫자일 경우 예외 처리")
    void inputIsNotRangeExceptionTest() {

        //소숫점으로 값을 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.inputIsNotRangeException("5.0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //소숫점으로 값을 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.inputIsNotRangeException("5.3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //앞에 기호를 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.inputIsNotRangeException("+5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //앞에 기호를 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.inputIsNotRangeException("-5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //앞에 0이란 숫자가 있을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.inputIsNotRangeException("05"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @Test
    @DisplayName("허용된 숫자열이 아닐 시 예외 처리")
    void inputIsNotNumberExceptionTest() {
        
        //숫자가 아닐 시 예외 처리
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotNumberException("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("게임 플레이중 잘못된 U, D이외를 누를경우 예외 처리")
    void invalidGameKeyTest() {

        //U나 D 이외의 문자를 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.invalidGameKey("A"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //U를 두번 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.invalidGameKey("UU"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //D를 두번 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.invalidGameKey("DD"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @Test
    @DisplayName("다시 시작할지 말지 R, Q이외를 누를경우 예외 처리")
    void invalidRetryRequestInputKeyTest() {

        //R이나 Q 이외의 문자를 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.invalidRetryRequestInputKey("A"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //R을 두번 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.invalidRetryRequestInputKey("RR"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        //Q를 두번 넣을 경우(에러)
        {
            assertThatThrownBy(() ->
                    ExceptionBasket.invalidRetryRequestInputKey("QQ"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

}