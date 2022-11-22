package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    ValidateInput validateInput;

    @BeforeEach
    void setValidateInput() {
        validateInput = new ValidateInput();
    }

    @DisplayName("다리 길이 입력 정상 케이스 확인")
    @ParameterizedTest
    @CsvSource(value = {"3", "12", "20"})
    void validateBridgeSizeTest1(String input) {
        validateInput.validateBridgeSize(input);
    }

    @DisplayName("다리 길이 입력 예외 발생 확인")
    @ParameterizedTest
    @CsvSource(value = {"asd", "2", "21"})
    void validateBridgeSizeTest2(String input) {
        Assertions.assertThatThrownBy(() -> validateInput.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이는 숫자이고, 범위는 [3,20]이어야 합니다.");
    }

    @DisplayName("입력이 숫자가 아니라면 flase반환, 숫자라면 true반환")
    @ParameterizedTest
    @CsvSource(value = {"a:false", "30:true"}, delimiter = ':')
    void checkIsNumberTest(String input, boolean output) {
        Assertions.assertThat(validateInput.checkIsNumber(input)).isEqualTo(output);
    }

    @DisplayName("입력이 범위에 있지 않다면 false반환, 범위에 있다면 true반환")
    @ParameterizedTest
    @CsvSource(value = {"2:false", "10:true", "21:false"}, delimiter = ':')
    void checkNumberInRange(String input, boolean output) {
        Assertions.assertThat(validateInput.checkNumberInRange(input)).isEqualTo(output);
    }

    @DisplayName("사용자 움직임 알파벳 정상 케이스 확인")
    @ParameterizedTest
    @CsvSource(value = {"U", "D"})
    void validateMoveAlphabetTest1(String input) {
        validateInput.validateMoveAlphabet(input);
    }

    @DisplayName("사용자 움직임 알파벳 예외 확인")
    @ParameterizedTest
    @CsvSource(value = {"K", "Q", "R"})
    void validateMoveAlphabetTest2(String input) {
        Assertions.assertThatThrownBy(()->validateInput.validateMoveAlphabet(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이동은 U 또는 D만 입력 가능합니다.");
    }

    @DisplayName("게임 재시도, 종료 입력 정상 케이스 확인")
    @ParameterizedTest
    @CsvSource(value = {"R", "Q"})
    void validateGameCommandTest1(String input) {
        validateInput.validateGameCommand(input);
    }

    @DisplayName("게임 재시도, 종료 입력 에외 케이스 확인")
    @ParameterizedTest
    @CsvSource(value = {"T", "P"})
    void validateGameCommandTest2(String input) {
        Assertions.assertThatThrownBy(() -> validateInput.validateGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionHandler.GAME_COMMAND_EXCEPTION);
    }
}