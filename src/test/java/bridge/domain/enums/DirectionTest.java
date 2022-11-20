package bridge.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("이동 명령 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DirectionTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "0", "u", "d", "", "\n", "_"})
    void 잘못된_이동_명령_입력시_예외_발생(String input) {
        assertThatThrownBy(() -> Direction.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_MOVE_COMMAND);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 이동_명령_정상_입력(String input) {
        String actual = Direction.of(input).getCommand();
        assertThat(actual).isEqualTo(input);
    }
}
