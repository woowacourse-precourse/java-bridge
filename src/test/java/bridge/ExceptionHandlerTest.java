package bridge;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import bridge.util.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ExceptionHandlerTest {

    @DisplayName("다리의 길이 입력 테스트 - 예외")
    @ValueSource(strings = {"1", "2", "21", "a", "", " ", "3 "})
    @ParameterizedTest
    void checkBridgeSizeTest_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkBridgeSize(input));
    }

    @DisplayName("다리의 길이 입력 테스트 - 정상")
    @ValueSource(strings = {"3", "20"})
    @ParameterizedTest
    void checkBridgeSizeTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkBridgeSize(input));
    }

    @DisplayName("다리 선택 입력 테스트 - 예외")
    @ValueSource(strings = {"", " ", "1", "d", "u"})
    void checkMovingTest_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkMoving(input));
    }

    @DisplayName("다리 선택 입력 테스트 - 정상")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void checkMovingTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkMoving(input));
    }

    @DisplayName("게임 재시작 입력 테스트 - 예외")
    @ValueSource(strings = {"", " ", "r", "a", "1"})
    @ParameterizedTest
    void checkRetryCommandTest_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkRetryCommand(input));
    }

    @DisplayName("게임 재시작 입력 테스트 - 정상")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void checkRetryCommandTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkRetryCommand(input));
    }

}
