package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.InputValidationError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("다리 길이 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void validateBridgeSizeTestIllegal(int size) {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateBridgeSize(size)).isEqualTo(
                InputValidationError.ERROR_BRIDGE_SIZE.exception
        );
    }

    @DisplayName("다리 길이 정상 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void validateBridgeSizeTestPass(int size) {
        InputValidator validator = new InputValidator();
        validator.validateBridgeSize(size);
    }

    @DisplayName("다리 길이 정수 변환 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"13I", "4D"})
    void validateBridgeSizeParsableTestIllegal(String cmd) {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateBridgeSizeParsable(cmd)).isEqualTo(
                InputValidationError.ERROR_BRIDGE_SIZE.exception
        );
    }

    @DisplayName("다리 길이 정수 변환 정상 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"13", "4"})
    void validateBridgeSizeParsableTestPass(String cmd) {
        InputValidator validator = new InputValidator();
        assertThat(validator.validateBridgeSizeParsable(cmd)).isEqualTo(Integer.parseInt(cmd));
    }


    @DisplayName("움직임 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Q", "E"})
    void validateMoveTestIllegal(String cmd) {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateMove(cmd)).isEqualTo(
                InputValidationError.ERROR_COMMAND_MOVE.exception
        );
    }

    @DisplayName("움직임 입력 정상 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateMoveTestPass(String cmd) {
        InputValidator validator = new InputValidator();
        validator.validateMove(cmd);
    }

    @DisplayName("게임 재시도 여부 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validateGameCommandIllegal(String cmd) {
        InputValidator validator = new InputValidator();
        assertThatThrownBy(() -> validator.validateGameCommand(cmd)).isEqualTo(
                InputValidationError.ERROR_COMMAND_RETRY.exception
        );
    }

    @DisplayName("게임 재시도 여부 입력 정상 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Q", "R"})
    void validateGameCommandPass(String cmd) {
        InputValidator validator = new InputValidator();
        validator.validateGameCommand(cmd);
    }

}
