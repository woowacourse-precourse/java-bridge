package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    @DisplayName("다리 길이를 입력할 때 숫자가 아니라면 예외 처리")
    @ValueSource(strings = {"dksehla", "d", "안돼", "@#"})
    @ParameterizedTest
    void should_onlyNumberBridgeSizeException_When_inputBridgeSize(String bridgeSize) {
        final String NOT_ONLY_NUMBER = "숫자만 입력이 가능합니다.";
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ONLY_NUMBER);
    }

    @DisplayName("다리 길이를 입력할 때 3미만이면 예외 처리")
    @ValueSource(ints = {2, 1})
    @ParameterizedTest
    void should_minBridgeSizeException_When_inputBridgeSize(Integer size) {
        final String NOT_MIN_SIZE = "다리의 길이는 최소 3이상이어야 합니다.";
        String bridgeSize = String.valueOf(size);
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MIN_SIZE);
    }

    @DisplayName("다리 길이를 입력할 때 20이상이라면 예외 처리")
    @ValueSource(strings = {"21", "50", "80", "100000"})
    @ParameterizedTest
    void should_maxBridgeSizeException_When_inputBridgeSize(String bridgeSize) {
        final String NOT_MAX_SIZE = "다리의 길이는 최대 20미만이어야 합니다.";
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MAX_SIZE);
    }

    @DisplayName("다리 길이를 입력할 때 올바른 값 입력하면 int형으로 반환한다.")
    @ValueSource(strings = {"14", "3", "7", "19"})
    @ParameterizedTest
    void should_returnBridgeSizeException_When_inputBridgeSize(String bridgeSize) {
        int size = InputValidator.checkBridgeSize(bridgeSize);
        assertThat(size).isEqualTo(Integer.parseInt(bridgeSize));
    }

    @DisplayName("칸을 선택할 때 형식(U 또는 D)에 맞지 않다면 예외 처리")
    @ValueSource(strings = {
            "A", "B", "C", "E", "F", "G", "H", "I", "G", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"})
    @ParameterizedTest
    void should_notFormatBlockException_When_inputBlock(String block) {
        final String NOT_FORMAT = "입력 형식이 맞지 않습니다.";
        assertThatThrownBy(() -> InputValidator.checkBlock(block))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_FORMAT);
    }

    @DisplayName("칸을 선택할 때 크기가 1이 아니라면 예외 처리")
    @ValueSource(strings = {"AG", "FDSFK", "231231", ",,.#@"})
    @ParameterizedTest
    void should_oneLengthBlockException_When_inputBlock(String block) {
        final String NOT_ONLY_ONE_SIZE = "크기는 1이어야 합니다.";
        assertThatThrownBy(() -> InputValidator.checkBlock(block))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ONLY_ONE_SIZE);
    }

    @DisplayName("칸을 올바르게 선택하면 그대로 반환")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void should_returnBlock_When_inputBlock(String block) {
        String moving = InputValidator.checkBlock(block);
        assertThat(moving).isEqualTo(block);
    }

    @DisplayName("게임 재시작 여부 입력할 때 크기가 1이 아니라면 예외 처리")
    @ValueSource(strings = {"AG", "FDSFK", "231231", ",,.#@"})
    @ParameterizedTest
    void should_oneLengthRetryException_When_inputGameRetry(String retry) {
        final String NOT_ONLY_ONE_SIZE = "크기는 1이어야 합니다.";
        assertThatThrownBy(() -> InputValidator.checkGameRetry(retry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ONLY_ONE_SIZE);
    }

    @DisplayName("게임 재시작 여부를 입력할 때 형식(R 또는 Q)에 맞지 않다면 예외 처리")
    @ValueSource(strings = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K", "L", "M", "N",
            "O", "P", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"})
    @ParameterizedTest
    void should_notFormatException_When_inputGameRetry(String retry) {
        final String NOT_FORMAT = "입력 형식이 맞지 않습니다.";
        assertThatThrownBy(() -> InputValidator.checkGameRetry(retry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_FORMAT);
    }

    @DisplayName("게임 재시작 여부를 입력할 때 올바른 값이 들어왔을 때 그대로 반환")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void should_returnGameRetry_When_inputGameRetry(String retry) {
        String inputRetry = InputValidator.checkGameRetry(retry);
        assertThat(inputRetry).isEqualTo(retry);
    }
}
