package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {
    @DisplayName("아무것도 입력하지 않은 경우")
    @Test
    void validateNullInput() {
        final String command = "";
        assertThatThrownBy(() -> Command.createCommand(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다시 입력해주세요.");
    }

    @DisplayName("R이나 Q가 아닌 문자를 입력할 경우")
    @ValueSource(strings = {"D", "0", "5", "-2", "-U", "RR", " Q"})
    @ParameterizedTest
    void validateRestartOrQuit(String command) {
        assertThatThrownBy(() -> Command.createCommand(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] R(재시도), 혹은 Q(종료)를 입력해주세요.");
    }

    @DisplayName("재시작 명령인지 확인하는 테스트")
    @Test
    void validateRestartCommand() {
        Command RestartCommand = Command.createCommand("R");
        Command QuitCommand = Command.createCommand("Q");

        assertThat(Command.isRestart(RestartCommand)).isTrue();
        assertThat(Command.isRestart(QuitCommand)).isFalse();
    }
}
