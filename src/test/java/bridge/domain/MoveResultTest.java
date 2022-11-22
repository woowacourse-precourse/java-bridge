package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveResultTest {
    MoveResult moveResult1 = new MoveResult(true, "U");
    MoveResult moveResult2 = new MoveResult(false, "D");

    @DisplayName("위쪽 다리 이동인지 확인한다.")
    @Test
    void UpMoveIsTrue() {
        boolean result1 = moveResult1.isUpMove();
        assertThat(result1).isEqualTo(true);

        boolean result2 = moveResult2.isUpMove();
        assertThat(result2).isEqualTo(false);
    }

    @DisplayName("다리 이동이 성공하였는지 확인한다.")
    @Test
    void SuccessMoveIsTrue() {
        boolean result1 = moveResult1.isSuccessMove();
        assertThat(result1).isEqualTo(true);
        boolean result2 = moveResult2.isSuccessMove();
        assertThat(result2).isEqualTo(false);
    }
}
