package bridge;

import bridge.CommandException;
import bridge.CommandParameter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CommandParameterTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "A", "B", "!"})
    void if_wrong_input(String input) {
        CommandException commandException = assertThrows(CommandException.class, () -> new CommandParameter(input));

        assertThat(commandException.getMessage()).contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Q", "R"})
    void if_right_input(String input) {
        CommandParameter commandParameter = new CommandParameter(input);

        assertThat(commandParameter.getCommand()).isEqualTo(input);
    }

    @Test
    void quiet() {
        CommandParameter key = new CommandParameter("Q");
        assertTrue(key.quiet());
    }
}