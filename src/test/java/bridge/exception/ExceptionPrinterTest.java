package bridge.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ExceptionPrinterTest {

    @Test
    void printAndThrowExceptionTest() {
        //given
        ExceptionMessage message = ExceptionMessage.INPUT_SHOULD_BE_U_OR_D;
        //when
        Throwable throwable = catchThrowable(() -> {
            ExceptionPrinter.printAndThrowException(message);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
