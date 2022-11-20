package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.Move.*;
import static bridge.domain.MoveResult.*;
import static org.assertj.core.api.Assertions.*;

class MoveResultTest {
    @DisplayName("Move 방향이 서로 같으면 SUCCESS를 반환한다.")
    @Test
    public void moveResultDecideTest() throws Exception {
        assertThat(MoveResult.decide(UP, UP)).isEqualTo(SUCCESS);
    }

    @DisplayName("Move 방향이 서로 다르면 FAIL을 반환한다.")
    @Test
    public void moveResultDecideFailTest() throws Exception {
        assertThat(MoveResult.decide(UP, DOWN)).isEqualTo(FAIL);
    }
}