package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    @DisplayName("생성자 테스트")
    public void userConstructorAndGetterTest() {
        // given

        // when
        User user = new User();

        // then
        assertThat(user.isGameDone()).isEqualTo(false);
        assertThat(user.getTrial()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 종료 메서드 테스트")
    public void successfulDoneTest() {
        // given
        User user = new User();

        // when
        user.winGame();

        // then
        assertThat(user.isGameDone()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 재시작 후 trial 카운팅 테스트")
    public void countTrialTest() {
        // given
        User user = new User();

        // when
        user.retry();

        // then
        assertThat(user.getTrial()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 성공 테스트")
    public void isSuccessTest() {
        // given
        User user = new User();

        // when
        user.winGame();

        // then
        assertThat(user.isGameDone()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 실패 테스트")
    public void isFailureTest() {
        // given
        User user = new User();

        // when
        user.loseGame();

        // then
        assertThat(user.isSuccessful()).isEqualTo(false);
        assertThat(user.isGameDone()).isEqualTo(true);
    }
}