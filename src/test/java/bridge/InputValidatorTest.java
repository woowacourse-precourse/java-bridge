package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    @DisplayName("다리 길이 입력 검증: 3부터 20 사이의 숫자는 통과")
    void givenValidNumberInput_whenCallValidateBridgeLengthInput_thenReturnTrue() {
        String test = "5";
        assertThat(InputValidator.validateBridgeLengthInput(test))
                .isTrue();
    }

    @Test
    @DisplayName("다리 길이 입력 검증: 숫자가 아니면 예외처리")
    void givenNonNumberInput_whenCallValidateBridgeLengthInput_thenThrowIllegalArgumentException() {
        String test = "not a number";
        assertThatThrownBy(() -> InputValidator.validateBridgeLengthInput(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.INVALID_BRIDGE_LENGTH_ERROR);
    }

    @Test
    @DisplayName("다리 길이 입력 검증: 최솟값보다 작으면 예외처리")
    void givenSmallerNumberInput_whenCallValidateBridgeLengthInput_thenThrowIllegalArgumentException() {
        String test = "1";
        assertThatThrownBy(() -> InputValidator.validateBridgeLengthInput(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.INVALID_BRIDGE_LENGTH_ERROR);
    }

    @Test
    @DisplayName("다리 길이 입력 검증: 최댓값보다 크면 예외처리")
    void givenBiggerNumberInput_whenCallValidateBridgeLengthInput_thenThrowIllegalArgumentException() {
        String test = "21";
        assertThatThrownBy(() -> InputValidator.validateBridgeLengthInput(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.INVALID_BRIDGE_LENGTH_ERROR);
    }

    @Test
    @DisplayName("이동 입력 검증: U나 D이면 통과")
    void givenValidInput_whenCallValidateBridgeGameMovingInput_thenReturnTrue() {
        Stream<String> tests = Stream.of("U", "D");
        tests.forEach(test ->
                assertThat(InputValidator.validateBridgeGameMovingInput(test))
                        .isTrue()
        );
    }

    @Test
    @DisplayName("이동 입력 검증: U나 D가 아니면 예외처리")
    void givenInvalidInput_whenCallValidateBridgeGameMovingInput_thenThrowIllegalArgumentException() {
        Stream<String> tests = Stream.of("Q", "R", "123");
        tests.forEach(test ->
                assertThatThrownBy(() -> InputValidator.validateBridgeGameMovingInput(test))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Messages.INVALID_MOVING_INPUT_ERROR)
        );
    }

    @Test
    @DisplayName("커맨드 입력 검증: R이나 Q면 통과")
    void givenValidInput_whenCallValidateBridgeGameCommandInput_thenReturnTrue() {
        Stream<String> tests = Stream.of("R", "Q");
        tests.forEach(test ->
                assertThat(InputValidator.validateBridgeGameCommandInput(test))
                        .isTrue()
        );
    }

    @Test
    @DisplayName("커맨드 입력 검증: R이나 Q가 아니면 예외처리")
    void givenInvalidInput_whenCallValidateBridgeGameCommandInput_thenThrowIllegalArgumentException() {
        Stream<String> tests = Stream.of("D", "U", "123");
        tests.forEach(test ->
                assertThatThrownBy(() -> InputValidator.validateBridgeGameCommandInput(test))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Messages.INVALID_GAME_COMMAND_INPUT_ERROR)
        );
    }
}
