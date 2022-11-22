package bridge.validator;

import static bridge.validator.GameCommandValidator.validateGameCommand;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.WrongGameCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandValidatorTest {

    @DisplayName("게임 재시작 여부는 R또는 Q이다.")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void gameCommandMustBeUorD(String input) {
        validateGameCommand(input);
    }

    @DisplayName("게임 재시작 여부가 R이나 Q가 아닐경우 예외 처리한다.")
    @ValueSource(strings = {"A", "B", "-U", "U", " ", ""})
    @ParameterizedTest
    void exceptWhenGameCommandNotRorQ(String input) {
        assertThatThrownBy(() -> validateGameCommand(input))
                .isInstanceOf(WrongGameCommandException.class);
    }
}