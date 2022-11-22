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
}