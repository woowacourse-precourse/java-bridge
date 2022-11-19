package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    @DisplayName("사용자를 생성한 뒤 초기 위치가 0인지 확인")
    void init_step_is_zero_after_create_user() {
        // given

        // when
        User user = new User();

        // then
        assertThat(user.getStep()).isEqualTo(0);
    }

    @Test
    @DisplayName("사용자를 생성한 뒤 게임 시도가 1회인지 테스트")
    void init_retryCount_is_zero_after_create_user() {
        // given

        // when
        User user = new User();

        // then
        assertThat(user.getTryCount()).isEqualTo(1);
    }
}
