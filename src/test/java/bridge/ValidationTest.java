package bridge;

import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.Validation.InputType;

class ValidationTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NO_LINE_FOUND_ERROR_MESSAGE = "[ERROR] 값을 입력해주세요.";

    @DisplayName("isNoLineFound 메소드 테스트: 모든 InputType에 대해")
    @ParameterizedTest
    @EnumSource(InputType.class)
    void isNoLineFoundMethodTest1(InputType inputType) {
        String lineInput = "";
        assertThatThrownBy(() -> { new Validation(lineInput, inputType); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NO_LINE_FOUND_ERROR_MESSAGE);
    }

    @DisplayName("validateBridgeSize 메소드 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3215183", "1*", "05", "2", "21", "0", "-5", "8.5"})
    void validateBridgeSizeMethodTest1(String lineInput) {
        InputType inputType = InputType.BRIDGESIZE;
        assertThatThrownBy(() -> { new Validation(lineInput, inputType); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateBridgeSize 메소드 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    void validateBridgeSizeMethodTest2(String lineInput) {
        InputType inputType = InputType.BRIDGESIZE;
        new Validation(lineInput, inputType);
    }

    @DisplayName("validateMovingCommand 메소드 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "25", "28", "RQ", "UD", "S", "*", "@", "H", "r", "q", "u", "d", "R", "Q"})
    void validateMovingCommandMethodTest1(String lineInput) {
        InputType inputType = InputType.MOVINGCOMMAND;
        assertThatThrownBy(() -> { new Validation(lineInput, inputType); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateMovingCommand 메소드 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateMovingCommandMethodTest2(String lineInput) {
        InputType inputType = InputType.MOVINGCOMMAND;
        new Validation(lineInput, inputType);
    }

    @DisplayName("validateMovingCommand 메소드 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "25", "28", "RQ", "UD", "S", "*", "@", "H", "r", "q", "u", "d", "U", "D"})
    void validateGameCommandMethodTest1(String lineInput) {
        InputType inputType = InputType.GAMECOMMAND;
        assertThatThrownBy(() -> { new Validation(lineInput, inputType); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("validateGameCommand 메소드 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void validateGameCommandMethodTest2(String lineInput) {
        InputType inputType = InputType.GAMECOMMAND;
        new Validation(lineInput, inputType);
    }
}