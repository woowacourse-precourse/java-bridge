package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @DisplayName("사용자가 생성되는 경우 위치는 0이다")
    @Test
    void createUserAndCheckPosition() {
        // given
        int expectedPosition = 0;

        // when
        User user = new User();

        // then
        assertThat(user.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("사용자가 생성되는 경우 초기 시도횟수는 1이다")
    @Test
    void createUserAndCheckTrial() {
        // given
        int expectedTrial = 1;

        // when
        User user = new User();

        // then
        assertThat(user.getTrial()).isEqualTo(expectedTrial);
    }

    @DisplayName("사용자가 다리의 한 단계를 통과하면 위치가 증가한다.")
    @Test
    void updateUserPositionWhenPassed() {
        // given
        User user = new User();
        int expectedPosition = 1;

        // when
        user.updatePosition();

        // then
        assertThat(user.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("사용자가 게임을 재시작하면 위치가 초기화된다.")
    @Test
    void resetUserPositionWithRetry() {
        // given
        User user = new User();
        user.updatePosition();
        int expectedPosition = 0;

        // when
        user.retry();

        // then
        assertThat(user.getPosition()).isEqualTo(expectedPosition);
    }

    @DisplayName("사용자가 게임을 재시작하면 시도 횟수가 증가한다.")
    @Test
    void addUserTrialWithRetry() {
        // given
        User user = new User();
        user.updatePosition();
        int expectedTrial = 2;

        // when
        user.retry();

        // then
        assertThat(user.getTrial()).isEqualTo(expectedTrial);
    }

}