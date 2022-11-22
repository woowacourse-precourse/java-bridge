package bridge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovingRetryCommandParameterTest {
    @ParameterizedTest
    @ValueSource(strings = {"3", "A", "B", "!"})
    void if_wrong_input(String input) {
        MovingCommandException commandException = assertThrows(MovingCommandException.class, () -> new MovingCommandParameter(input));

        assertThat(commandException.getMessage()).contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void if_right_input(String input) {
        MovingCommandParameter commandParameter = new MovingCommandParameter(input);

        assertThat(commandParameter.getMovingCommand()).isEqualTo(input);
    }

}