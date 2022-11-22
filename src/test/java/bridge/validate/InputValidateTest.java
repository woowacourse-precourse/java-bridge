package bridge.validate;

import bridge.message.Error;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidateTest {

    InputValidate inputValidate;

    @BeforeEach
    void init(){
        inputValidate = new InputValidate();
    }

    @Test
    void 입력_타입_검증_테스트() {
        assertThatThrownBy( () -> {
            inputValidate.validateCharacter("abc");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(Error.WRONG_BRIDGE_NUMBER);
    }

    @Test
    void 입력_범위_검증_테스트() {
        assertThatThrownBy( () -> {
            inputValidate.validateInputRange("123");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(Error.WRONG_BRIDGE_NUMBER);
    }

    @Test
    void 입력_공백_검증_테스트() {
        assertThatThrownBy( () -> {
            inputValidate.validateInputEmpty("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(Error.WRONG_BRIDGE_NUMBER);
    }

    @Test
    void 입력_방향_검증_테스트() {
        assertThatThrownBy( () -> {
            inputValidate.validateMoving("E");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(Error.WRONG_DIRECTION_INPUT);
    }

    @Test
    void 입력_재시도_검증_테스트() {
        assertThatThrownBy( () -> {
            inputValidate.validateRetry("E");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage(Error.WRONG_RETRY_INPUT);
    }
}