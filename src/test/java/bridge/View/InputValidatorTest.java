package bridge.View;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.View.InputValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("다리길이 입력 validator 실패 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {")", "ㅁ", "a", "0", "2", "21"})
    void 다리길이입력_validator_실패_테스트(String bridge_size_input) {
        assertThrows(IllegalArgumentException.class,()->{
            validateBridgeSize(bridge_size_input);
        });
    }

    @DisplayName("다리길이 입력 validator 성공 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"3", "5", "10", "20"})
    void 다리길이입력_validator_성공_테스트(String bridge_size_input) {
        assertDoesNotThrow(()->validateBridgeSize(bridge_size_input));
    }

    @DisplayName("이동 방향 validator 성공 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"U","D"})
    void 이동_방향_validator_성공_테스트(String moving_direction) {
        assertDoesNotThrow(()->validateMovingDirection(moving_direction));
    }

    @DisplayName("이동 방향 validator 실패 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"UD","d","u","a","1","-"})
    void 이동_방향_validator_실패_테스트(String moving_direction) {
        assertThrows(IllegalArgumentException.class,
                () -> validateMovingDirection(moving_direction));
    }
}