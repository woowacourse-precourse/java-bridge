package bridge;

import bridge.model.UserInput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputTest {

    private static final UserInput userInput = new UserInput();

    @ParameterizedTest
    @CsvSource({"R", "t"})
    void 입력값이_U나_D가_아닌_경우_test(String input) {
        assertThatThrownBy(() -> userInput.validateInputMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"restart", "t"})
    void 입력값이_R나_Q가_아닌_경우_test(String input) {
        assertThatThrownBy(() -> userInput.validateRestartOrQuit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
