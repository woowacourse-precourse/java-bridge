package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCountTest {

    @DisplayName("매번 시도를 할 때 마다 시도 횟수가 올라가는 테스트")
    @Test
    void retryCountTest() {
        TryCount tryCount = new TryCount();

        assertThat(tryCount.getTryCount()).isEqualTo(1);

        for (int count = 2; count <= 10; count++) {
            tryCount.retry();
            assertThat(tryCount.getTryCount()).isEqualTo(count);
        }
    }
}
