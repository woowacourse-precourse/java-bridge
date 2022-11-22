package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    @DisplayName("Game 생성자 테스트")
    @Test
    public void GameTest() {


        Game game = new Game();

        assertThat(game.isWinGame()).isEqualTo(false);
        assertThat(game.isWinGame()).isEqualTo(false);
        assertThat(game.getGameCount()).isEqualTo(1);

    }

    @DisplayName("게임이 이겼거나, 끝났으면 winGame과 GameDone을 true를 반환해주는 테스트")
    @Test
    public void winGameAndGameDoneTest() {

        Game game = new Game();

        game.winGame();
        game.GameDone();

        assertThat(game.isWinGame()).isEqualTo(true);
        assertThat(game.isGameDone()).isEqualTo(true);
    }

    @DisplayName("게임을 재시작하면 gameCount를 1 늘려주는 테스트")
    @Test
    public void restartGameTest() {

        Game game = new Game();

        game.restartGame();
        game.restartGame();

        assertThat(game.getGameCount()).isEqualTo(3);
    }




}
