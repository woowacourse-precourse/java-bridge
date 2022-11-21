package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    @DisplayName("다리 길이를 입력할 때 숫자가 아니라면 예외 처리")
    @ValueSource(strings = {"dksehla", "d", "안돼", "@#"})
    @ParameterizedTest
    void onlyNumberBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력이 가능합니다.");
    }

    @DisplayName("다리 길이를 입력할 때 3미만이면 예외 처리")
    @ValueSource(strings = {"2", "-1", "2.5", "1"})
    @ParameterizedTest
    void minBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이는 최소 3이상이어야 합니다.");
    }

    @DisplayName("다리 길이를 입력할 때 20이상이라면 예외 처리")
    @ValueSource(strings = {"21", "50", "80", "100000"})
    @ParameterizedTest
    void maxBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이는 최대 20이하여야 합니다.");
    }

    @DisplayName("다리 길이를 입력할 때 올바른 값 입력하면 int형으로 반환한다.")
    @ValueSource(strings = {"14", "3", "7", "19"})
    @ParameterizedTest
    void correctBridgeSize(String bridgeSize) {
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
    void notFormatBlock(String block) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(block))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("칸을 선택할 때 크기가 1이 아니라면 예외 처리")
    @ValueSource(strings = {"AG", "FDSFK", "231231", ",,.#@"})
    @ParameterizedTest
    void oneLengthBlock(String block) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(block))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부 입력할 때 1이 아니라면 예외 처리")
    @ValueSource(strings = {"AG", "FDSFK", "231231", ",,.#@"})
    @ParameterizedTest
    void oneLengthRetry(String retry) {
        assertThatThrownBy(() -> InputValidator.checkGameRetry(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 여부를 입력할 때 형식(R 또는 Q)에 맞지 않다면 예외 처리")
    @ValueSource(strings = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K", "L", "M", "N",
            "O", "P", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"})
    @ParameterizedTest
    void notFormatRetry(String retry) {
        assertThatThrownBy(() -> InputValidator.checkBridgeSize(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
