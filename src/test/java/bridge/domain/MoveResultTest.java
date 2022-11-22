package bridge.domain;

import static bridge.domain.MoveResult.CAN_MOVE_MARK;
import static bridge.domain.MoveResult.CAN_NOT_MOVE_MARK;
import static bridge.domain.MoveResult.EMPTY_MARK;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveResultTest {

    @Test
    @DisplayName("success 를 수행하면 이동한 칸에 O 다른 칸은 빈칸으로 이동내역에 저장된다.")
    void success() {
        // given
        MoveResult moveResult = new MoveResult();

        // when
        moveResult.success(BridgeCellType.UP);

        // then
        assertThat(moveResult.getMoveHistory().get(BridgeCellType.UP).get(0))
            .isEqualTo(CAN_MOVE_MARK);
        assertThat(moveResult.getMoveHistory().get(BridgeCellType.DOWN).get(0))
            .isEqualTo(EMPTY_MARK);
    }

    @Test
    @DisplayName("fail 을 수행하면 이동한 칸에 X 다른 칸은 빈칸으로 이동내역에 저장된다.")
    void fail() {
        // given
        MoveResult moveResult = new MoveResult();

        // when
        moveResult.fail(BridgeCellType.UP);

        // then
        assertThat(moveResult.getMoveHistory().get(BridgeCellType.UP).get(0))
            .isEqualTo(CAN_NOT_MOVE_MARK);
        assertThat(moveResult.getMoveHistory().get(BridgeCellType.DOWN).get(0))
            .isEqualTo(EMPTY_MARK);
    }
}