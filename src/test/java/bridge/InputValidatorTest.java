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

    @Test
    @DisplayName("다리 개수 입력시 범위 초과시 예외처리")
    void inputBridgeSizeOutOfSize() throws Exception {
        //given
        String input = "25";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 개수 입력시 최소값 미달시 예외처리")
    void inputBridgeSizeLess() throws Exception {
        //given
        String input = "2";
        //when
        //then
        assertThatThrownBy(() -> inputValidator.validateInputBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    

}