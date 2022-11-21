package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputHandlerTest {

    @DisplayName("공통 예외 - 사용자 입력이 비어있는 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "")
    void handleEmptyInputExceptionTest(String input) {
        TotalExceptionHandler emptyInputHandler = overrideToEmptyInputException();

        ExceptionTestHelper.testIllegalArgumentException(emptyInputHandler, input);
    }

    TotalExceptionHandler overrideToEmptyInputException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleEmptyInputException(input);
            }
        };
    }

    @DisplayName("공통 예외 - 사용자 입력이 숫자 혹은 알파벳이 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"@!#", " "})
    void handleNotNumberOrAlphabetExceptionTest(String input) {
        TotalExceptionHandler notNumberAlphabetHandler = overrideToNotNumberOrAlphabetException();

        ExceptionTestHelper.testIllegalArgumentException(notNumberAlphabetHandler, input);
    }

    TotalExceptionHandler overrideToNotNumberOrAlphabetException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleNotNumberOrAlphabetException(input);
            }
        };
    }

    @DisplayName("다리길이 예외 - 사용자 입력이 숫자가 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "ABC"})
    void handleNotNumberExceptionTest(String input) {
        TotalExceptionHandler notNumberHandler = overrideToNotNumberException();

        ExceptionTestHelper.testIllegalArgumentException(notNumberHandler, input);
    }

    TotalExceptionHandler overrideToNotNumberException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleNotNumberException(input);
            }
        };
    }

    @DisplayName("이동 및 재시작 예외 - 사용자 입력이 대문자 알파벳이 아닌 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "abc"})
    void handleNotUpperAlphabetExceptionTest(String input) {
        TotalExceptionHandler notUpperAlphabetHandler = overrideToNotUpperAlphabetException();

        ExceptionTestHelper.testIllegalArgumentException(notUpperAlphabetHandler, input);
    }

    TotalExceptionHandler overrideToNotUpperAlphabetException() {
        return new TotalExceptionHandler() {
            @Override
            public void handleException(String input) {
                InputExceptionHandler.handleNotUpperAlphabetException(input);
            }
        };
    }

}
