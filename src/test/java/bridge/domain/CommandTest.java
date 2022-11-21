package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private static final String ERROR = "[ERROR]";

    @DisplayName("입력에 맞는 Command를 반환한다.")
    @Test
    void getCommand() {
        assertThat(Command.getCommand("Q")).isEqualTo(Command.QUIT);
    }

    @DisplayName("잘못된 입력으로 Command을 찾으면 예외가 발생한다.")
    @Test
    void getCommandWithInvalidInput() {
        assertThatThrownBy(() -> Command.getCommand("c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
