package bridge.command;

import static bridge.config.ExceptionMessage.ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OptionTest {

    @DisplayName("알파벳 대문자만 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"a", "Aa", "aA", "1A", ""})
    @ParameterizedTest
    void inputNotUppercase(String input) {
        assertThatThrownBy(() -> Option.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }

    @DisplayName("옵션은 1글자를 받지 않으면 예외가 발생")
    @ValueSource(strings = {"UU", "", "UDUUD"})
    @ParameterizedTest
    void inputWrongRange(String input) {
        assertThatThrownBy(() -> Option.validate(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }

    @DisplayName("게임 옵션을 Q나 R를 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"A", "B"})
    @ParameterizedTest
    void inputNotGameCommand(String input) {
        assertThatThrownBy(() -> new Command(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }

    @DisplayName("플레이어 이동을 U나 D를 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"Q", "R"})
    @ParameterizedTest
    void inputNotMove(String input) {
        assertThatThrownBy(() -> new Move(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }
}
