package bridge.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExceptionHandlerTest {

    ExceptionHandler exceptionHandler = new ExceptionHandler();

    @DisplayName("다리의 길이 입력 테스트 - 예외")
    @ValueSource(strings = {"1", "2", "21", "a", "", " ", "3 "})
    @ParameterizedTest
    void checkBridgeSizeTest_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionHandler.checkBridgeSize(input));
    }

    @DisplayName("다리의 길이 입력 테스트 - 정상")
    @ValueSource(strings = {"3", "20"})
    @ParameterizedTest
    void checkBridgeSizeTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> exceptionHandler.checkBridgeSize(input));
    }

    @DisplayName("다리 선택 입력 테스트 - 예외")
    @ValueSource(strings = {"", " ", "1", "d", "u"})
    @ParameterizedTest
    void checkMovingTest_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionHandler.checkMoving(input));
    }

    @DisplayName("다리 선택 입력 테스트 - 정상")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void checkMovingTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> exceptionHandler.checkMoving(input));
    }

    @DisplayName("게임 재시작 입력 테스트 - 예외")
    @ValueSource(strings = {"", " ", "r", "a", "1"})
    @ParameterizedTest
    void checkRetryCommandTest_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> exceptionHandler.checkRetryCommand(input));
    }

    @DisplayName("게임 재시작 입력 테스트 - 정상")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void checkRetryCommandTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> exceptionHandler.checkRetryCommand(input));
    }

}
