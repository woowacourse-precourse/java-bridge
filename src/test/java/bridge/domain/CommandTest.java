package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CommandTest {

    @DisplayName("R은 재식작을 의미하고 Q는 종료를 의마한다")
    @ParameterizedTest
    @CsvSource(value = {"R:Restart", "Q:Quit"}, delimiter = ':')
    void 커맨드_생성_테스트(String commandString, String command) {
        Command expected = Command.Restart;
        if (command.equals("Quit")) {
            expected = Command.Quit;
        }
        assertThat(Command.getCommandByString(commandString)).isEqualTo(expected);
    }
}