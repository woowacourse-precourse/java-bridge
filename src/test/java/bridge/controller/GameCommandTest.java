package bridge.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static bridge.controller.GameCommand.QUIT;
import static bridge.controller.GameCommand.RESTART;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {
    @DisplayName("command를 넘겨주면 GameState 가 반환된다")
    @Test
    void convertCommand() {
        GameCommand restartCommand = GameCommand.parseCommandToInstance(RESTART.getCommand());
        GameCommand quitCommand = GameCommand.parseCommandToInstance(QUIT.getCommand());

        assertThat(restartCommand).isEqualTo(RESTART);
        assertThat(quitCommand).isEqualTo(QUIT);
    }

    @DisplayName("지정되지 않은 값을 넘겨주면 예외가 발생한다.")
    @Test
    void convertCommandFail() {
        assertThatThrownBy(() -> GameCommand.parseCommandToInstance(RESTART.getCommand() + "AROES"))
                .isInstanceOf(NoSuchElementException.class);
    }
}