package bridge.domain.command;

import static bridge.domain.command.RetryCommand.QUIT;
import static bridge.domain.command.RetryCommand.RETRY;
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
        void through_right_value_is_ok(String rightValue) {
            assertThatNoException().isThrownBy(() -> new RetryCommand(rightValue));
        }

        @DisplayName("올바른 값이 아니라면 예외를 반환한다.")
        @Test
        void through_right_value_is_exception() {
            assertThatThrownBy(() -> new RetryCommand("wrongValue"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("내부 메시지가")
    @Nested
    class IsRetry {

        @DisplayName(RETRY + "일시 true를 반환한다.")
        @Test
        void if_message_is_retry_return_true() {
            assertThat(new RetryCommand(RETRY).isRetry()).isTrue();
        }

        @DisplayName(RETRY + "가 아닐시 false를 반환한다.")
        @Test
        void if_message_is_not_retry_return_false() {
            assertThat(new RetryCommand(QUIT).isRetry()).isFalse();
        }
    }
}