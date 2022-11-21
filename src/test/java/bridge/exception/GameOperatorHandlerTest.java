package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameOperatorHandlerTest {

    @DisplayName("방향 입력 과정 - 입력된 값이 U 혹은 D가 아닐 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12", "A", "R", "Q"})
    void handleNotUOrDExceptionTest(String input) {
        TotalExceptionHandler notUOrDHandler = overrideToNotUOrDException();

        ExceptionTestHelper.testIllegalArgumentException(notUOrDHandler, input);
    }

    TotalExceptionHandler overrideToNotUOrDException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(String input) {
                GameOperatorExceptionHandler.handleNotUOrDException(input);
            }
        };
    }

    @DisplayName("게임 재시작 여부 입력 과정 - 입력된 값이 R 혹은 Q가 아닐 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12", "A", "U", "D"})
    void handleNotROrQExceptionTest(String input) {
        TotalExceptionHandler notROrQHandler = overrideToNotROrQException();

        ExceptionTestHelper.testIllegalArgumentException(notROrQHandler, input);
    }

    TotalExceptionHandler overrideToNotROrQException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(String input) {
                GameOperatorExceptionHandler.handleNotROrQException(input);
            }
        };
    }
}
