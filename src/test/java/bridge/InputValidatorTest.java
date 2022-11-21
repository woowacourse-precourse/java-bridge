package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputValidatorTest {


    @DisplayName("다리 길이 검사 입력값이 범위를 벗어난 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, -3, 200, Integer.MAX_VALUE})
    public void checkValidBridgeLength(int bridgeLength) {
        assertThatThrownBy(() -> InputValidator.checkIsValidBridgeRange(bridgeLength)).
                isInstanceOf(IllegalArgumentException.class).hasMessageContaining(Message.BRIDGE_LENGTH_RANGE_ERROR);
    }

    @DisplayName("다리 길이 정상 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "4"})
    public void bridgeLengthTest(String input) {
        setInput(input);
        assertEquals(InputValidator.getValidateInput(InputType.BRIDGE), input);
    }

    @DisplayName("다리 길이 입력 예외 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1000", " "})
    public void bridgeLengthExceptionTest(String input) {
        setInput(input);
        assertThatThrownBy(() -> InputValidator.getValidateInput(InputType.BRIDGE)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동칸 입력 예외 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings={"aaa","1000"," "})
    public void bridgeMoveInputExceptionTest(String input){
        setInput(input);
        assertThatThrownBy(() -> InputValidator.getValidateInput(InputType.MOVE)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동칸 입력 정상 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings={"U","D"})
    public void bridgeMoveInputTest(String input){
        setInput(input);
        assertEquals(InputValidator.getValidateInput(InputType.MOVE), input);
    }

    public void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
