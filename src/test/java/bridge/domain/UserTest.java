package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User();

    @Test
    void 재시작_횟수_테스트() {

        user.retry();

        user.retry();

        Assertions.assertThat(user.getRetry()).isEqualTo(3);
    }
}