package bridge.validator;

import bridge.exception.ExceptionType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @DisplayName("다리길이 입력시 숫자가 아닌 경우 실패")
    @Test
    void 다리_길이_입력에_대한_타입_검증_테스트() {
        String errorMessage = ExceptionType.INTEGER_TYPE_EXCEPTION.getErrorMessage();
        String bridgeSizeInput = "a";
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSizeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("다리길이 입력시 3보다 작거나 20보다 클 경우 숫자 입력시 예외 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "21", "22", "23"})
    void 다리_길이_입력에_대한_범위_검증_테스트_실패(String bridgeSize) {
        String errorMessage = ExceptionType.BRIDGE_RANGE_EXCEPTION.getErrorMessage();
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    @DisplayName("다리 길이 입력 경계 값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void 다리_길이_입력에_대한_범위_검증_테스트_성공(String bridgeSize) {
        assertThat(Validator.validateBridgeSize(bridgeSize))
                .isEqualTo(Integer.parseInt(bridgeSize));
    }


    @DisplayName("이동 관련 입력시 U 또는 D를 입력하지 않은 경우 실패")
    @ParameterizedTest
    @ValueSource(strings = {"A", "1", "x"})
    void 이동_입력값에_대한_검증_테스트_실패(String movement) {
        assertThatThrownBy(() -> Validator.validateMoving(movement))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.MOVE_TYPE_EXCEPTION.getErrorMessage());
    }

    @DisplayName("이동 관련 입력시 U 또는 D를 입력한 경우 성공")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 이동_입력값에_대한_검증_테스트_성공(String movement) {
        assertThat(Validator.validateMoving(movement))
                .isEqualTo(movement);
    }

    @DisplayName("게임 재시작 관련 입력시 Q 또는 R을 입력하지 않은 경우 실패")
    @ParameterizedTest
    @ValueSource(strings = {"A", "1", "x"})
    void 게임_진행_입력값에_대한_검증_테스트_실패(String gameCommand) {
        assertThatThrownBy(() -> Validator.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.GAME_COMMAND_EXCEPTION.getErrorMessage());
    }

    @DisplayName("게임 재시작 관련 입력시 Q 또는 R를 입력한 경우 성공")
    @ParameterizedTest
    @ValueSource(strings = {"Q", "R"})
    void 게임_진행_입력값에_대한_검증_테스트_성공(String gameCommand) {
        assertThat(Validator.validateGameCommand(gameCommand))
                .isEqualTo(gameCommand);
    }
}
