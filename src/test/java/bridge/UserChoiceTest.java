package bridge;

import bridge.Model.WrappingType.UserChoice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UserChoiceTest {
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    @DisplayName("유효")
    void valid(String choice) {
        UserChoice userChoice = new UserChoice(choice);
        assertThat(userChoice).isInstanceOf(UserChoice.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U12", "D3", "2", "안녕하세요"})
    @DisplayName("예외")
    void notValid(String choice) {
        assertThatThrownBy(() -> {
            new UserChoice(choice);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
