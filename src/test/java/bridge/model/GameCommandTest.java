package bridge.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCommandTest {

    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";
    private static final String OTHER_COMMAND = "A";

    @DisplayName("재시작 버튼을 누르면 R을 반환한다.")
    @Test
    void pressRetry() {
        assertThat(GameCommand.fromCommand(RETRY_COMMAND)).isEqualTo(GameCommand.RETRY);
    }

    @DisplayName("게임종료 버튼을 누르면 Q를 반환한다.")
    @Test
    void pressQuit() {
        assertThat(GameCommand.fromCommand(QUIT_COMMAND)).isEqualTo(GameCommand.QUIT);
    }

    @DisplayName("재시작, 게임종료 이외의 버튼을 누르면 예외가 발생한다.")
    @Test
    void pressNotRetryAndQuit() {
        assertThatThrownBy(() -> GameCommand.fromCommand(OTHER_COMMAND)).isInstanceOf(IllegalArgumentException.class);
    }
}
