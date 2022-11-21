package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRestartInputExceptionTest {

    private GameRestartInputException gameRestartInputException = new GameRestartInputException();

    @Test
    @DisplayName("사용자 입력은 R, Q로만 이루어져야 한다.")
    void isUserInputConsistOfRQ() {
        assertThatThrownBy(() -> gameRestartInputException.inputOnlyConsistOfRQ("U")).isInstanceOf(
                IllegalArgumentException.class);
    }
}