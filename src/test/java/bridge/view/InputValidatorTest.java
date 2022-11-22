package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.view.InputValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("다리길이 입력 validator 실패 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {")", "ㅁ", "a", "0", "2", "21"})
    void 다리길이입력_validator_실패_테스트(String bridgeSizeInput) {
        assertThrows(IllegalArgumentException.class,()->{
            validateBridgeSize(bridgeSizeInput);
        });
    }

    @DisplayName("다리길이 입력 validator 성공 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"3", "5", "10", "20"})
    void 다리길이입력_validator_성공_테스트(String bridgeSizeInput) {
        assertDoesNotThrow(()->validateBridgeSize(bridgeSizeInput));
    }

    @DisplayName("이동 방향 입력 validator 성공 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"U","D"})
    void 이동_방향_validator_성공_테스트(String movingDirection) {
        assertDoesNotThrow(()->validateMovingDirection(movingDirection));
    }

    @DisplayName("이동 방향 입력 validator 실패 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"UD","d","u","a","1","-"})
    void 이동_방향_validator_실패_테스트(String movingDirection) {
        assertThrows(IllegalArgumentException.class,
                () -> validateMovingDirection(movingDirection));
    }

    @DisplayName("재시작 종료 입력 validator 성공 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"Q","R"})
    void 재시작_종료_입력_validator_성공_테스트(String gameCommand) {
        assertDoesNotThrow(()->validateGameCommand(gameCommand));
    }

    @DisplayName("재시작 종료 입력 validator 실패 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"QR","RQ","q","r","A","1","-"})
    void 재시작_종료_입력_validator_실패_테스트(String gameCommand) {
        assertThrows(IllegalArgumentException.class,
                () -> validateGameCommand(gameCommand));
    }
}