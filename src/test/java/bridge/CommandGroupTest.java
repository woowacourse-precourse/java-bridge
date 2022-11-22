package bridge;

import bridge.view.CommandGroup;
import bridge.view.CommandType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandGroupTest {

    @DisplayName("명령어의 그룹을 올바르게 불러올 때")
    @CsvSource(value = {"MOVE_TO_UP:MOVE", "MOVE_TO_DOWN:MOVE", "GAME_RETRY:GAME_CONTROL", "GAME_QUIT:GAME_CONTROL"}, delimiter = ':')
    @ParameterizedTest
    public void loadValidCommandGroup(CommandType commandType, CommandGroup commandGroup) {
        assertThat(CommandGroup.findByCommandType(commandType)).isEqualTo(commandGroup);
    }

    @DisplayName("명령어의 그룹을 찾을 수 없을 때")
    @Test
    public void loadInvalidCommandGroup() {
        assertThatThrownBy(() -> CommandGroup.findByCommandType(null))
                .isInstanceOf(NoSuchElementException.class);
    }
}
