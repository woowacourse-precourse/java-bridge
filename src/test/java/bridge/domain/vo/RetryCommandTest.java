package bridge.domain.vo;

import static bridge.domain.vo.RetryCommand.QUIT;
import static bridge.domain.vo.RetryCommand.RETRY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RetryCommandTest {

    @Nested
    @DisplayName("게임 재시작 여부 메시지가")
    class CreateRetryCommand {

        @DisplayName("올바른 값이라면 정상적으로 retryCommand를 생성한다")
        @ValueSource(strings = {RETRY, QUIT})
        @ParameterizedTest
        void When_InputRightValue_Expect_CreateInstance(String rightValue) {
            assertThatNoException().isThrownBy(() -> new RetryCommand(rightValue));
        }

        @DisplayName("올바른 값이 아니라면 예외를 반환한다.")
        @Test
        void When_InputWrongValue_Expect_Exception() {
            assertThatThrownBy(() -> new RetryCommand("wrongValue"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("내부 메시지가")
    @Nested
    class IsRetry {

        @DisplayName(RETRY + "일시 true를 반환한다.")
        @Test
        void When_MessageIsRetry_Expect_True() {
            assertThat(new RetryCommand(RETRY).isRetry()).isTrue();
        }

        @DisplayName(RETRY + "가 아닐시 false를 반환한다.")
        @Test
        void When_MessageIsNotRetry_Expect_False() {
            assertThat(new RetryCommand(QUIT).isRetry()).isFalse();
        }
    }
}