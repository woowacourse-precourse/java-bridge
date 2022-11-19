package bridge.model;

import static bridge.model.GameCommand.validateGameCommandInput;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"K", "L", "0", "kwkl", "아아아아"})
    void 잘못된_입력값(String input) {
        assertThatThrownBy(() -> validateGameCommandInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}