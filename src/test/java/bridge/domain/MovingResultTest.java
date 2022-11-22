package bridge.domain;

import static bridge.domain.enums.BlockStatus.DOWN;
import static bridge.domain.enums.BlockStatus.UP;
import static bridge.domain.enums.CrossStatus.FAIL;
import static bridge.domain.enums.CrossStatus.SUCCESS;
import static bridge.domain.enums.CrossStatus.YET;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovingResultTest {

    @DisplayName("사용자가 가장 최근 움직인 칸이 성공 혹은 실패인지 상, 하 칸에 따른 결과 문자 반환 테스트")
    @Test
    void getMovingResultStatus_success() {
        // given
        Bridge bridge = new Bridge(new Blocks(List.of(UP, UP, DOWN, DOWN)),
                new CrossStatuses(List.of(SUCCESS, FAIL, YET, YET)));
        MovingResult movingResult = bridge.getMovingResult();

        // when
        String lastMoveTopResult = movingResult.getLastMoveResult(UP);
        String lastMoveBottomResult = movingResult.getLastMoveResult(DOWN);

        // then
        assertThat(lastMoveTopResult).isEqualTo("   ");
        assertThat(lastMoveBottomResult).isEqualTo(" X ");
    }
}