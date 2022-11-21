package bridge.domain;

import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {

    @DisplayName("플레이어가 올바른 명령어 입력시 정상적으로 동작한다.")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void createRightCommand(String input) {
        Command command = new Command(input);
        assertThat(command.getCommand()).isEqualTo(input);
    }

    @DisplayName("플레이어가 빈 값 입력 시 에러가 발생한다.")
    @Test
    void createNullCommand() {
        assertThatThrownBy(() -> new Command(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.COMMAND_TYPE.getMessage());
    }

    @DisplayName("플레이어가 R, Q 외 문자 입력 시 에러가 발생한다.")
    @ValueSource(strings = {"r", "q", "RA", "QA"})
    @ParameterizedTest
    void createCommandNotInType(String input) {
        assertThatThrownBy(() -> new Command(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.COMMAND_TYPE.getMessage());
    }

    @DisplayName("플레이어가 R, Q 외 문자 입력 시 에러가 발생한다.")
    @ValueSource(strings = {"RR", "QQ", "RQ", "QR"})
    @ParameterizedTest
    void createTogetherCommand(String input) {
        assertThatThrownBy(() -> new Command(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.COMMAND_TYPE.getMessage());
    }
}
