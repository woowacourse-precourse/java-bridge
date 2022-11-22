package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameCommandTest {

    @DisplayName("문자열 'Q'가 주어질 때 GameCommand를 반환합니다.")
    @Test
    void  QUIT_GAME_COMMAND_탐색() {
        String command = "Q";

        GameCommand gameCommand = GameCommand.findByCommand(command);

        assertThat(gameCommand).isEqualTo(GameCommand.QUIT);
    }

    @DisplayName("문자열 'R'가 주어질 때 GameCommand를 반환합니다.")
    @Test
    void  RETRY_GAME_COMMAND_탐색() {
        String command = "R";

        GameCommand gameCommand = GameCommand.findByCommand(command);

        assertThat(gameCommand).isEqualTo(GameCommand.RETRY);
    }

    @DisplayName("주어진 GameCommand에 관하여 Command를 반환합니다.")
    @Test
    void  GAME_COMMAND_반환() {
        String retryCommand = "R";
        String quitCommand = "Q";

        GameCommand retry = GameCommand.findByCommand(retryCommand);
        GameCommand quit = GameCommand.findByCommand(quitCommand);

        assertThat(retry).isEqualTo(GameCommand.RETRY);
        assertThat(quit).isEqualTo(GameCommand.QUIT);
    }

}