package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class ExceptionBasketTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    //@Test
    @ValueSource(strings = {"5.0", "5.3", "+5", "-5", "05"})
    @DisplayName("1~20이외의 숫자일 경우 예외 처리")
    @ParameterizedTest
    void inputIsNotRangeExceptionTest(String input) {

        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotRangeException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
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