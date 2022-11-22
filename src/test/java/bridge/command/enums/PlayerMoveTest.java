package bridge.command.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerMoveTest {

    @DisplayName("숫자 1을 입력하면 U, 0을 입력하면 D를 반환")
    @CsvSource({
        "1, U",
        "0, D"
    })
    @ParameterizedTest
    void findPlayerMoveTest(Integer number, String name) {
        assertThat(PlayerMove.findMove(number)).isEqualTo(name);
    }

    @DisplayName("입력된 문자가 움직임에 관하면 true, 아니면 false를 반환")
    @CsvSource({
        "U, true",
        "D, true",
        "A, false"
    })
    @ParameterizedTest
    void isInPlayerMoveTest(String move, boolean result) {
        assertThat(PlayerMove.isInPlayerMove(move)).isEqualTo(result);
    }

    @DisplayName("R과 Q를 입력하면 RESTART, END가 반환되고 나머지는 UNKNOWN")
    @CsvSource({
        "R, RESTART",
        "Q, END",
        "A, UNKNOWN"
    })
    @ParameterizedTest
    void findGameCommandTest(String input, GameCommand gameCommand) {
        assertThat(GameCommand.findGameCommand(input)).isEqualTo(gameCommand);
    }

    @DisplayName("게임 명령어에 속하는 Q, R를 입력하면 true 나머지는 false를 반환")
    @CsvSource({
        "R, true",
        "Q, true",
        "A, false"
    })
    @ParameterizedTest
    void isInGameCommandTest(String input, boolean result) {
        assertThat(GameCommand.isInGameCommand(input)).isEqualTo(result);
    }
}
