package bridge;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCommandTest {
    @DisplayName("문자열을 GameCommand 객체로 변환 테스트")
    @Test
    public void getGameCommandFromStringTest() {
        assertThat(GameCommand.getGameCommand("R")).isEqualTo(GameCommand.RETRY);
        assertThat(GameCommand.getGameCommand("Q")).isEqualTo(GameCommand.QUIT);
    }

    @DisplayName("문자열 GameCommand 객체 변환 예외 테스트")
    @Test
    public void getGameCommandFromStringExceptionTest() {
        assertThatThrownBy(() -> GameCommand.getGameCommand("START"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
