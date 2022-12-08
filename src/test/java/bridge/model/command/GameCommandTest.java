package bridge.model.command;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.util.ExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {


    @Nested
    class invalidInputTest {

        @DisplayName("R,Q가 아닌 값은 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"r", "q", "12", "아닌데아닌데"})
        void 비정상_입력(String input) {
            assertThatThrownBy(() -> GameCommand.from(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_GAME_COMMAND.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"R", "Q"})
        void 정상_입력(String input) {
            assertThatCode(() -> GameCommand.from(input))
                    .doesNotThrowAnyException();
        }

        @Test
        void 입력값_체크() {
            Assertions.assertEquals(GameCommand.RETRY, GameCommand.from("R"));
            Assertions.assertEquals(GameCommand.QUIT, GameCommand.from("Q"));
        }
    }

}