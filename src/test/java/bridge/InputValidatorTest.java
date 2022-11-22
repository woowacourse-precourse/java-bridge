package bridge;

import bridge.Utils.InputValidator;
import bridge.Utils.InputType;
import bridge.Utils.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


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

    @DisplayName("다리 길이 입력 예외 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1000"})
    public void bridgeLengthExceptionTest(String input) {
        assertThatThrownBy(() -> InputValidator.getValidateInput(InputType.BRIDGE,input)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동칸 입력 예외 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings={"aaa","1000"})
    public void bridgeMoveInputExceptionTest(String input){
        assertThatThrownBy(() -> InputValidator.getValidateInput(InputType.MOVE,input)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동칸 입력 정상 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings={"U","D"})
    public void bridgeMoveInputTest(String input){
        assertEquals(InputValidator.getValidateInput(InputType.MOVE,input), input);
    }

    @DisplayName("재시작 입력 예외 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings={"test","111"})
    public void gameReplayInputExceptionTest(String input){
        assertThatThrownBy(() -> InputValidator.getValidateInput(InputType.REPLAY,input)).
                isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("재시작 입력 정상 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings={"R","Q"})
    public void gameReplayTest(String input){
        assertEquals(InputValidator.getValidateInput(InputType.REPLAY, input), input);
    }

}