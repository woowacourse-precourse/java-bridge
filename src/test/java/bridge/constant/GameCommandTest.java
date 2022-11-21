package bridge.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameCommandTest {

    @DisplayName("R, Q가 주어질 때 GameCommand 생성")
    @Test
    void createGameCommand() {
        GameCommand restart = GameCommand.of("R");
        GameCommand quit = GameCommand.of("Q");
        assertThat(restart.isRestart()).isTrue();
        assertThat(quit.isQuit()).isTrue();
    }
}
