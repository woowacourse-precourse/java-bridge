package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameCommandTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ValueSource(strings = {"RR", "1", "q"})
    @ParameterizedTest
    void 입력_예외_테스트(String userGameCommand) {
        assertThatThrownBy(() -> GameCommand.validateInput(userGameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 반환_테스트() {
        GameCommand.validateInput("R");
        assertThat(GameCommand.getGameCommand()).isEqualTo("R");
    }
}