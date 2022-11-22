package bridge.bridgeGame;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.IllegalArgumentExceptionMessage;
import org.junit.jupiter.api.Test;

class GameCommandTest {
    @Test
    public void gameCommandFromStringSuccessTest() throws Exception {
        // given
        String command = "R";

        // when
        GameCommand gameCommand = GameCommand.fromString(command);

        // then
        assertThat(gameCommand).isEqualTo(GameCommand.COMMAND_RETRY);
    }

    @Test
    public void gameCommandFromStringFailTest() throws Exception {
        // given
        String command = "Z";

        // when

        // then
        assertThatThrownBy(() -> GameCommand.fromString(command)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionMessage.ILLEGAL_GAME_COMMAND.getMessage());
    }
}