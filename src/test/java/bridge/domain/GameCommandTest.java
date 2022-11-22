package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCommandTest {

    @DisplayName("[성공] R로 GameCommand 생성")
    @Test
    void createGameCommandByR() {
        String gameCommand = "R";
        assertThat(GameCommand.of(gameCommand)).isEqualTo(GameCommand.R);
    }

    @DisplayName("[성공] Q로 GameCommand 생성")
    @Test
    void createGameCommandByQ() {
        String gameCommand = "Q";
        assertThat(GameCommand.of(gameCommand)).isEqualTo(GameCommand.Q);
    }

    @DisplayName("[예외 발생] GameCommand을 생성할 때 R이나 Q가 아니라면 IllegalArgumentException 발생")
    @Test
    void createGameCommandByNonRQ() {
        String gameCommand = "A";
        assertThatThrownBy(() -> GameCommand.of(gameCommand)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
