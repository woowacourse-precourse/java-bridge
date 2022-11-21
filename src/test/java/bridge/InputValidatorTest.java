package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();
    
    @Test
    @DisplayName("다리 개수 입력시 숫자가 아닐 때 예외처리")
    void inputBridgeSizeNotNumber() throws Exception {
        //given
        String input = "1b";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}