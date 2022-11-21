package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.model.enums.RetryIntention;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RetryIntentionTest {
    private final String RETRY = RetryIntention.RETRY.intention;
    private final String QUIT = RetryIntention.QUIT.intention;
    private final String ERROR = "E";
    @Nested
    @DisplayName("wantRetry 메서드는 문자열을 입력받아")
    class describe_wantRetry {

        @Test
        @DisplayName("알맞은 입력인 경우 게임 재시작 여부를 반환한다.")
        void returnMovingTest() {
            assertThat(RetryIntention.wantRetry(RETRY)).isEqualTo(true);
            assertThat(RetryIntention.wantRetry(QUIT)).isEqualTo(false);
        }

        @Test
        @DisplayName("알맞이 않은 입력인 경우 예외를 발생시킨다")
        void throwException(){
            assertThatThrownBy(() -> RetryIntention.wantRetry(ERROR)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
