package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.GameCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCommandTest {

    @DisplayName("[예외 발생] GameCommand을 생성할 때 R이나 Q가 아니라면 IllegalArgumentException 발생")
    @Test
    void createGameCommandByNonRQ() {
        String gameCommand = "A";
        assertThatThrownBy(() -> GameCommand.of(gameCommand)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
