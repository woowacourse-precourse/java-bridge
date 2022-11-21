package bridge;

import bridge.constant.GameCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameCommandTest {

    @Test
    void 재시작_입력_테스트() {
        String command = "R";
        assertThat(GameCommand.isRetry(command)).isTrue();
        command = "Q";
        assertThat(GameCommand.isQuit(command)).isTrue();
    }
}
