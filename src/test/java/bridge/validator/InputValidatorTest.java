package bridge.validator;

import static bridge.messages.ErrorMessage.INVALID_GAME_COMMAND_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {

    @DisplayName("잘못된 게임 커맨드 입력시 예외 발생 검증 테스트")
    @ParameterizedTest
    @CsvSource({"2", "ㅂ", "d", "q", "r", "]"})
    void validateGameCommand(String inputGameCommand) {
        // given
        // when
        // then
        assertThatThrownBy(() -> InputValidator.validateGameCommand(inputGameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_GAME_COMMAND_ERROR);
    }
}