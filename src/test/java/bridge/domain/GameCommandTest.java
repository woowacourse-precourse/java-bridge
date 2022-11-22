package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Application;
import bridge.domain.command.GameCommand;
import bridge.utils.parser.CommandInputParser;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest extends NsTest {

    @DisplayName("올바른 값(R, Q)을 입력한 경우 정상 작동한다.")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void create_legal_gameCommand(String input) {
        final String commandInput = input;

        GameCommand gameCommand = CommandInputParser.parseGameCommand(commandInput);

        assertThat(gameCommand).isNotNull();
    }

    @DisplayName("대문자가 아닌, 잘못된 값을 입력한 경우 IllegalArgumentException 이 발생한다.")
    @ValueSource(strings = {"a", "21f", ""})
    @ParameterizedTest
    void create_illegalValue(String input) {
        final String commandInput = input;

        assertThatThrownBy(() -> CommandInputParser.parseGameCommand(commandInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("대문자이지만, 등록되지 않은 커멘드를 입력한 경우 IllegalArgumentException 이 발생한다.")
    @ValueSource(strings = {"F", "A", "C",})
    @ParameterizedTest
    void create_notExistCommand(String input) {
        final String commandInput = input;

        assertThatThrownBy(() -> CommandInputParser.parseGameCommand(commandInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("게임이 중단되었을 때 재실행 커멘드를 입력하면 게임이 재실행된다.")
    @Test
    void create_restartCommand() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                "[ O |   | O ]",
                "[   | O |   ]"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("게임이 중단되었을 때 재실행 커멘드를 입력하면 게임이 재실행된다.")
    @Test
    void create_quitCommand() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "Q");
            assertThat(output()).contains(
                "[   ]",
                "[ X ]"
            );

            int upSideIndex = output().indexOf("[   ]");
            int downSideIndex = output().indexOf("[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}