package bridge.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserExceptionTest {

    @Test
    @DisplayName("빈 값을 입력하면 에러 메시지는 ExceptionCode의 에러 메시지다.")
    void isEmptyTest() {
        CustomUserException userException = new CustomUserException();
        try {
            userException.isEmpty("");
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            assertThat(ExceptionCode.IS_EMPTY.getMessage()).isEqualTo(errorMessage);
        }
    }

    private static class CustomUserException extends UserException {
        @Override
        public void checkException(String userInput) {
        }
    }
}
