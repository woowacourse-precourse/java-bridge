package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.utils.CommandInputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MovingCommandTest {

    @DisplayName("올바른 값(U, D)을 입력한 경우 정상 작동한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void create_legal_movingCommand(String input) {
        final String commandInput = input;

        MovingCommand movingCommandEnum = CommandInputParser.parseWithCheckingEmpty(commandInput);

        assertThat(movingCommandEnum).isNotNull();
    }

    @DisplayName("대문자가 아닌, 잘못된 값을 입력한 경우 IllegalArgumentException 이 발생한다.")
    @ValueSource(strings = {"a", "21f", ""})
    @ParameterizedTest
    void create_illegalValue(String input) {
        final String commandInput = input;

        assertThatThrownBy(() -> CommandInputParser.parseWithCheckingEmpty(commandInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("대문자이지만, 등록되지 않은 커멘드를 입력한 경우 IllegalArgumentException 이 발생한다.")
    @ValueSource(strings = {"F", "A", "C",})
    @ParameterizedTest
    void create_notExistCommand(String input) {
        final String commandInput = input;

        assertThatThrownBy(() -> CommandInputParser.parseWithCheckingEmpty(commandInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

}