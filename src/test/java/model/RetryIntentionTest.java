package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.filter;

import com.sun.net.httpserver.Authenticator.Retry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RetryIntentionTest {

    private static String retryIntention = RetryIntention.RETRY.intention;
    private static String quitIntention = RetryIntention.QUIT.intention;

    @Nested
    @DisplayName("wantRetry 메서드는 문자열을 입력받아")
    class describe_getMoving {

        @Test
        @DisplayName("알맞은 RetryIntention 객체의 wantRetry 값을 반환한다.")
        void returnMovingTest() {
            assertThat(RetryIntention.wantRetry(retryIntention)).isEqualTo(true);
            assertThat(RetryIntention.wantRetry(quitIntention)).isEqualTo(false);
        }

        @Test
        @DisplayName("유효하지 않은 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> RetryIntention.wantRetry("q")).isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> RetryIntention.wantRetry("r")).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
