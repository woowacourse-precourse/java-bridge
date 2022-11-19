package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    @DisplayName("생성자, getter 테스트")
    public void userConstructorAndGetterTest() {
        // given

        // when
        User user = new User();

        // then
        assertThat(user.isGameDoneStatus()).isEqualTo(false);
        assertThat(user.getGameTryCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("user setter 테스트")
    public void userSetterTest() {
        // given
        User user = new User();
        int gameTryCount = 10;
        boolean gameDoneSuccess = true;

        // when
        user.setGameTryCount(gameTryCount);
        user.setGameDoneStatus(gameDoneSuccess);

        // then
        assertThat(user.getGameTryCount()).isEqualTo(gameTryCount);
        assertThat(user.isGameDoneStatus()).isEqualTo(gameDoneSuccess);
    }

    @Test
    @DisplayName("게임 종료 메서드 테스트")
    public void gameDoneSuccessTest() {
        // given
        User user = new User();

        // when
        user.gameDoneSuccess();

        // then
        assertThat(user.isGameDoneStatus()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 재시작시 gameTryCount 카운팅 테스트")
    public void gameRetryTest() {
        // given
        User user = new User();

        // when
        user.gameRetry();

        // then
        assertThat(user.getGameTryCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 성공 테스트")
    public void isGameSuccessTest() {
        // given
        User user = new User();

        // when
        user.gameWin();

        // then
        assertThat(user.isGameWin()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임 실패 테스트")
    public void isGameFailTest() {
        // given
        User user = new User();

        // when
        user.gameFail();

        // then
        assertThat(user.isGameWin()).isEqualTo(false);
    }
}
