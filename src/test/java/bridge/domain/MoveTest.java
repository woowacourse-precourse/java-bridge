package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveTest {
    Move UpMove = new Move("U");
    Move DownMove = new Move("D");

    @DisplayName("위쪽 다리 이동인지 판별")
    @Test
    void isMovingUpside() {
        boolean resultTrue = UpMove.isUpMove();
        boolean resultFalse = DownMove.isUpMove();

        assertThat(resultTrue).isEqualTo(true);
        assertThat(resultFalse).isEqualTo(false);
    }

    @DisplayName("다리 이동이 유효한지 판별")
    @Test
    void isSuccessMove() {
        boolean resultTrue = UpMove.goToNextMove("U");
        boolean resultFalse = UpMove.goToNextMove("D");

        assertThat(resultTrue).isEqualTo(true);
        assertThat(resultFalse).isEqualTo(false);
    }
}
