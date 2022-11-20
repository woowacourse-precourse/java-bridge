package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandTest {
    @DisplayName("R 또는 Q 외의 값이 입력되면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "123", ""})
    void createMovingNoCommand(String noCommand) {
        assertThatThrownBy(() -> new GameCommand(noCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}