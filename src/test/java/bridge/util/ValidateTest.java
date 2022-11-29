package bridge.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidateTest {

    Validate validate = new Validate();

    @ParameterizedTest
    @ValueSource(strings = {"2", "25", "a", "ㄱ"})
    @DisplayName("(예외)다리 길이 검증_예외의 경우")
    void validateBridgeSizeException(String input) {
        Assertions.assertThatThrownBy(() -> {
            validate.validateBridgeSize(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    @DisplayName("다리 길이 검증 올바른 경우")
    void validateBridgeSize(String input) {
        int isRight = 0;
        validate.validateBridgeSize(input);
        isRight = 1;
        Assertions.assertThat(isRight).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "W", "&"})
    @DisplayName("(예외)움직임 입력 값 검증")
    void validateMovingException(String input) {
        Assertions.assertThatThrownBy(() -> {
            validate.validateMoving(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    @DisplayName("올바른 움직임 입력 값 검증")
    void validateMoving(String input) {
        int isRight = 0;
        validate.validateMoving(input);
        isRight = 1;
        Assertions.assertThat(isRight).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "W", "&"})
    @DisplayName("(예외)게임 시작 종료 시 검증")
    void validateGameDefinitionException(String input) {
        Assertions.assertThatThrownBy(() -> {
            validate.validateGameDefinition(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    @DisplayName("올바른 입력시 게임 시작 종료 검증")
    void validateGameDefinition(String input) {
        int isRight = 0;
        validate.validateGameDefinition(input);
        isRight = 1;
        Assertions.assertThat(isRight).isEqualTo(1);
    }


}