package bridge.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();
    @Test
    void validateBridgeSizeTest_3_미만인_경우() {
        //given
        int size = 2;
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateBridgeSize(size);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateBridgeSizeTest_20_초과인_경우() {
        //given
        int size = 21;
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateBridgeSize(size);
        });
        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateBridgeSizeTest_정상() {
        //given
        int size = 10;
        //when
        Throwable throwable = catchThrowable(() -> {
            inputValidator.validateBridgeSize(size);
        });
        //then
        assertThat(throwable)
                .isNull();
    }
}
