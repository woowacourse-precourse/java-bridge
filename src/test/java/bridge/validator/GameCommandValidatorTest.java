package bridge.validator;

import bridge.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameCommandValidatorTest {
    @Test
    void 게임_재시작_및_종료_입력이_R_또는_Q가_아니라면_예외를_발생한다(){
        String lowerInput = "r";
        String wrongInput = "X";

        Assertions.assertThatThrownBy(() -> GameCommandValidator.validateGameCommand(lowerInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_GAME_COMMAND_VALUE);
        Assertions.assertThatThrownBy(() -> GameCommandValidator.validateGameCommand(wrongInput))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessage.WRONG_GAME_COMMAND_VALUE);
    }
}