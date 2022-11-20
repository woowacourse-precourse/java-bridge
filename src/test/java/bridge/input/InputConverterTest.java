package bridge.input;

import bridge.util.InputConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputConverterTest {

    @ParameterizedTest
    @DisplayName("숫자로만 이루어진 사용자 입력이 정수 범위를 넘을 경우 에러 메세지와 함께 IllegalArgumentException이 발생한다.")
    @ValueSource(strings = {"12345678910", "12345678910111213","123456789101213141516171819"})
    public void convertUserInputToBridgeSizeWithOverInteger(String userInput) throws Exception{
        //given
        final String OVERSIZED_INPUT_MSG = "정수 범위를 넘은 입력값입니다.";
        //when
        //then
        Assertions.assertThatThrownBy(() -> InputConverter.toInt(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OVERSIZED_INPUT_MSG);
    }
}
