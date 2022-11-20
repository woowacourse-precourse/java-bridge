package bridge;

import bridge.Model.WrappingType.ChoiceDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ChoiceDirectionTest {
    @Nested
    @DisplayName("유효값 테스트")
    class validDataTest {
        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        @DisplayName("유효")
        void valid(String choice) {
            ChoiceDirection userChoice = new ChoiceDirection(choice);
            assertThat(userChoice).isInstanceOf(ChoiceDirection.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"U12", "D3", "2", "안녕하세요"})
        @DisplayName("예외")
        void notValid(String choice) {
            assertThatThrownBy(() -> {
                new ChoiceDirection(choice);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
