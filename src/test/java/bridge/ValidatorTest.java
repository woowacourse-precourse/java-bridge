package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

class ValidatorTest {
    private final Validator validator = new Validator();

    @DisplayName("사이즈 숫자 확인_정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"5", "10", "15", "20"})
    void checkSizeByInt_Success(String sizeName) {
        assertThatCode(() -> validator.checkSizeByInt(sizeName))
                .doesNotThrowAnyException();
    }

    @DisplayName("사이즈 숫자 확인_예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"a", "-", "1a", "s0"})
    void checkSizeByInt_Fail(String sizeName) {
        assertThatCode(() -> validator.checkSizeByInt(sizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.incorrectSize.getMessage());
    }

    @DisplayName("사이즈 범위 확인_정상작동")
    @ParameterizedTest
    @CsvSource(value = {"3", "5", "10", "15"})
    void checkSizeInScope_Success(String sizeName) {
        assertThatCode(() -> validator.checkSizeInScope(sizeName))
                .doesNotThrowAnyException();
    }

    @DisplayName("사이즈 범위 확인_예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"0", "21", "-10", "100"})
    void checkSizeInScope_fail(String sizeName) {
        assertThatCode(() -> validator.checkSizeInScope(sizeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.sizeOverScope.getMessage());
    }

    @DisplayName("생성된 다리 길이 확인_정상 작동")
    @Test
    void checkBridgeSize_Success() {
        assertThatCode(() -> {
            List<String> bridge = List.of("U", "U", "D");
            validator.checkBridgeSize(3, bridge);
        }).doesNotThrowAnyException();
    }

    @DisplayName("생성된 다리 길이 확인_예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"0", "5", "6", "7"})
    void checkBridgeSize_Fail(int size) {
        assertThatCode(() -> {
            List<String> bridge = List.of("U", "U", "D");
            validator.checkBridgeSize(size, bridge);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.bridgeNotEqualsSize.getMessage());
    }

    @DisplayName("생성된 다리 단어 확인_정상 작동")
    @Test
    void checkBridgeWord_Success() {
        assertThatCode(() -> {
            List<String> bridge = List.of("U", "U", "D");
            validator.checkBridgeWord(bridge.size(), bridge);
        }).doesNotThrowAnyException();
    }

    @DisplayName("생성된 다리 단어 확인_예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"0", "-", "a", "X"})
    void checkBridgeWord_Fail(String word) {
        assertThatCode(() -> {
            List<String> bridge = List.of("U", "U", word);
            validator.checkBridgeWord(bridge.size(), bridge);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.createBridgeWordNotUD.getMessage());
    }


    @DisplayName("이동 단어 확인_정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"U", "D"})
    void checkMoveWord_Success(String move) {
        assertThatCode(() -> validator.checkMoveWord(move))
                .doesNotThrowAnyException();
    }

    @DisplayName("이동 단어 확인_예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"x", "1", "UU"})
    void checkMoveWord_Fail(String move) {
        assertThatCode(() -> validator.checkMoveWord(move))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.moveByNotUD.getMessage());
    }

    @DisplayName("종료 혹은 재시작 단어 확인_정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"R", "Q"})
    void checkCommandWord_Success(String command) {
        assertThatCode(() -> validator.checkCommandWord(command))
                .doesNotThrowAnyException();
    }

    @DisplayName("종료 혹은 재시작 단어 확인_예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"sad", "Qq", "1"})
    void checkCommandWord_Fail(String command) {
        assertThatCode(() -> validator.checkCommandWord(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.commandByNotRQ.getMessage());
    }
}