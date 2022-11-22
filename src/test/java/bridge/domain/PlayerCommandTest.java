package bridge;

import bridge.domain.PlayerCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.utils.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerCommandTest {
    @ParameterizedTest
    @DisplayName("입력값이 R or Q가 아니면 예외가 발생한다.")
    @ValueSource(strings = {" ", "r", "q", "1R"})
    void createPlayerCommandByNotOptions(String input) {
        assertThatThrownBy(() -> new PlayerCommand(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(GAME_COMMAND_NOT_OPTIONS);
    }
}
