package bridge.input;

import bridge.util.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    
    @Test
    @DisplayName("다리생성을 위한 사용자 입력이 비어 있거나 공백으로만 이루어진 경우 에러 메세지와 함께 IllegalArgumentException이 발생한다.")
    public void validateBlankInput() throws Exception{
        //given
        InputValidator inputValidator = new InputValidator();
        final String BLANK_INPUT_MSG = "비어 있는 입력값 입니다.";
        String userInput = "";
        //when
        //then
        Assertions.assertThatThrownBy(() -> inputValidator.validateBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_INPUT_MSG);
    }
}
