package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionBasketTest {

    public static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("1~20이외의 숫자일 경우 예외 처리")
    void inputIsNotRangeExceptionTest(){
        assertThatThrownBy(() ->
                ExceptionBasket.inputIsNotRangeException("05"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

}