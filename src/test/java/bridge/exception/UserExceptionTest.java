package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserExceptionTest {
    CustomUserException userException = new CustomUserException();

    @Test
    @DisplayName("빈 값을 입력하면 에러 메시지는 ExceptionCode의 에러 메시지다.")
    void isEmptyTest() {
        try {
            userException.isEmpty("");
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            assertThat(ExceptionCode.IS_EMPTY.getMessage()).isEqualTo(errorMessage);
        }
    }

    @Test
    @DisplayName("공백을 입력하면 예외를 반환한다.")
    void isBlankTest() {
        assertThrows(IllegalArgumentException.class, () -> userException.isBlank(" "));
    }

    @ParameterizedTest
    @DisplayName("공백을 포함한 값을 입력하면 예외를 반환한다.")
    @ValueSource(strings = {"1 ", " U", " R "})
    void hasBlankTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> userException.hasBlank(input));
    }

    @Test
    @DisplayName("길이가 1이 아닌 값을 입력하면 예외를 반환한다.")
    void isNotLengthOneTest() {
        assertThrows(IllegalArgumentException.class, () -> userException.isNotLengthOne("RR"));
    }

    @ParameterizedTest
    @DisplayName("소문자를 입력하면 예외를 반환한다.")
    @MethodSource("generateLowerCaseData")
    void isLowerCaseTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> userException.isLowerCase(input));
    }

    private static class CustomUserException extends UserException {
        @Override
        public void checkException(String userInput) {
        }
    }

    public static List<String> generateLowerCaseData() {
        List<String> data = new ArrayList<>();
        for (int i = 97; i < 123; i++) {
            char letter = (char) i;
            data.add(String.valueOf(letter));
        }
        return data;
    }
}
