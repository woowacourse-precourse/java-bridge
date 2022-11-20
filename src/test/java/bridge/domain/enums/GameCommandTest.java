package bridge.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("재시작 / 종료 명령 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "r", "q", "", "`", "\n", "1"})
    void 잘못된_명령_입력시_예외_발생(String input) {
        assertThatThrownBy(() -> GameCommand.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_GAME_COMMAND);
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 정상_입력_재시작_종료_명령_생성(String input) {
        GameCommand gameCommand = GameCommand.of(input);
        assertThat(gameCommand.getCommand()).isEqualTo(input);
    }
}
