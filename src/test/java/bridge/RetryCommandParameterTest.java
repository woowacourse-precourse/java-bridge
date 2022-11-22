package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RetryCommandParameterTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "A", "B", "!"})
    void if_wrong_input(String input) {
        MovingCommandException commandException = assertThrows(MovingCommandException.class, () -> new RetryCommandParameter(input));

        assertThat(commandException.getMessage()).contains("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Q", "R"})
    void if_right_input(String input) {
        RetryCommandParameter retryCommandParameter = new RetryCommandParameter(input);

        assertThat(retryCommandParameter.getCommand()).isEqualTo(input);
    }

    @Test
    void quiet() {
        RetryCommandParameter key = new RetryCommandParameter("Q");
        assertTrue(key.quiet());
    }
}