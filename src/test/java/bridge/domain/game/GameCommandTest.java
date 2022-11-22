package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.utils.game.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameCommandTest {

    @Nested
    @DisplayName("findNextGameOver 메소드는")
    class DescribeFindNextGameOverMethodTest {

        @Nested
        @DisplayName("만약 게임을 다시 시도할지에 대한 커맨드가 주어지면")
        class ContextWithCommandTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "Q:GAME_EXIT",
                        "R:GAME_PLAY"
                    },
                    delimiter = ':'
            )
            @DisplayName("커맨드와 일치하는 GameStatus를 반환한다")
            void it_returns_gameStatus(String command, GameStatus expected) {
                GameStatus actual = GameCommand.findNextGameOver(command);

                assertThat(actual).isSameAs(expected);
            }
        }
    }
}
