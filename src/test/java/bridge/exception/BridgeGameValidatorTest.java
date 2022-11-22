package bridge.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameValidatorTest {

    BridgeGameValidator bridgeGameValidator;

    @BeforeEach()
    void init(){
        bridgeGameValidator = new BridgeGameValidator();
    }

    @DisplayName("정수로 input이 들어오지 않았을 때 예외 발생")
    @ParameterizedTest(name = "[{index}] input={0}")
    @ValueSource(strings = { "" , "100p", "!!", "!@#","a","abcd"})
    void 정수_예외_테스트(String str) {
        assertThatThrownBy(() -> bridgeGameValidator.validateInt(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위가 3~20이 아닌 경우 예외 발생")
    @ParameterizedTest(name = "[{index}] input={0}")
    @ValueSource(ints = { 1, 2, 0, -1, 21, 100})
    void 범위_예외_테스트(int size) {
        assertThatThrownBy(() -> bridgeGameValidator.isValidGameNumber(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U/D로 input이 들어오지 않았을 때 예외 발생")
    @ParameterizedTest(name = "[{index}] input={0}")
    @ValueSource(strings = { " " , "", "A", "!@#","a","abcd", "u","p","Q","R","안녕"})
    void 업다운_예외_테스트(String str) {
        assertThatThrownBy(() -> bridgeGameValidator.validateUpAndDown(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R/Q로 input이 들어오지 않았을 때 예외 발생")
    @ParameterizedTest(name = "[{index}] input={0}")
    @ValueSource(strings = { " " , "", "A", "!@#","a","abcd", "u","p","U","D","안녕"})
    void 재시작_예외_테스트(String str) {
        assertThatThrownBy(() -> bridgeGameValidator.validateRestartAndQuit(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

}