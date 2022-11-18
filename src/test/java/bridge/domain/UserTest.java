package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User();

    @Test
    void 사용자_위치와_재시작_횟수_테스트() {
        user.move("D");
        user.move("D");
        user.move("U");

        user.resetPosition();

        user.move("U");
        user.move("D");

        user.resetPosition();

        user.move("D");

        Assertions.assertThat(user.getPosition()).containsExactly("D");
        Assertions.assertThat(user.getRetry()).isEqualTo(2);
    }
}