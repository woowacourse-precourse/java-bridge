package bridge;

import bridge.validation.MoveInputException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RetryInputExceptionTest extends NsTest {

    @DisplayName("R과 Q를 입력하지 않았을 때 예외 발생")
    @Test
    void checkAlphabetUAndD() {
        String input = "b";

        assertThatThrownBy(() -> {
            MoveInputException.validateMoveInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소문자 r과 q를 입력했을 때 예외 발생")
    @Test
    void checkCapitalLetter() {
        String input = "r";

        assertThatThrownBy(() -> {
            MoveInputException.validateMoveInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R과 Q를 제대로 입력했을 때 정상 작동 확인")
    @Test
    void checkRightAlphabet() {
        String input = "U";

        assertThatCode(() -> {
            MoveInputException.validateMoveInput(input);
        }).doesNotThrowAnyException();

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
