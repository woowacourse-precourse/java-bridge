package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
