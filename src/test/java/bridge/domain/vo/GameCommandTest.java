package bridge.domain.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.constants.ErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"R", "Q"})
    void Normal_Test(String input) {
        Assertions.assertThat(GameCommand.from(input).toString()).isEqualTo(input);
    }

    @DisplayName("Unvalidated GameCommand")
    @ParameterizedTest(name = "[{index}] input {0} ")
    @ValueSource(strings = {"a", "1", "r", "q", "d", "u"})
    void Unvalidated_GameCommand_exception(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            GameCommand.from(input);
        });
        assertEquals(ErrorCode.GAME_COMMAND_NOT_R_Q.getException().getMessage(),
                exception.getMessage());
    }
}