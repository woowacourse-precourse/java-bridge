package bridge.model;

import bridge.constant.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MoveTest {

    private Move move = new Move();
    private BridgePosition bridgePosition;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("D", "D", "D"));
        bridgePosition = new BridgePosition(bridge);
    }

    @DisplayName("이동의 성공/실패 여부를 반환한다.")
    @Test
    void judgeMoveTest() {
        move.setMoveDirection("U");
        bridgePosition.addCurrentRoundNumber();

        Score score = move.judge(bridgePosition);

        assertThat(score).isEqualTo(Score.FAIL);
    }
}