package bridge.validatorTest;

import bridge.validator.Validator;
import bridge.view.Messages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    Validator validator =  new Validator();

    @Test
    @DisplayName("사용자의 입력이 숫자가 아니면 예외를 반환한다")
    void numericTest() {
        String userInput = "A";

        try {
            validator.validateInputIsNumber(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_INPUT_NUMBER.getMessage());
        }

    }

    @Test
    @DisplayName("입력한 다리의 길이가 3 ~ 20 사이가 아니면 예외 반환한다")
    void bridgeSizeTest() {
        String userInput = "21";

        try {
            validator.validateBridgeSize(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_BRIDGE_SIZE.getMessage());
        }

    }

    @Test
    @DisplayName("입력한 move가 U,D가 아니면 예외를 반환한다")
    void moveTest() {
        String userInput = "z";

        try {
            validator.validateMove(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_MOVE.getMessage());
        }
    }

    @Test
    @DisplayName("입력한 retry가 R,Q가 아니면 예외를 반환한다")
    void retryTest() {
        String userInput ="A";

        try {
            validator.validateGameCommand(userInput);
        } catch (Exception e) {
            Assertions.assertThat(e.getMessage()).isEqualTo(Messages.ERROR_GAME_COMMAND.getMessage());
        }
    }
}
