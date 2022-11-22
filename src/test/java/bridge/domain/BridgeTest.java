package bridge.domain;

import static bridge.domain.enums.BlockStatus.DOWN;
import static bridge.domain.enums.BlockStatus.UP;
import static bridge.domain.enums.CrossStatus.FAIL;
import static bridge.domain.enums.CrossStatus.SUCCESS;
import static bridge.domain.enums.CrossStatus.YET;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("현재까지 움직인 다리의 각 칸의 상태에 따른 결과 생성 테스트")
    @Test
    void getMovingResult() {
        // given
        Bridge bridge = new Bridge(new Blocks(List.of(UP, UP, DOWN, DOWN)),
                new CrossStatuses(List.of(SUCCESS, FAIL, YET, YET)));

        // when
        MovingResult movingResult = bridge.getMovingResult();

        // then
        Assertions.assertAll(() -> {
            assertThat(movingResult.getMovingResultStatus()).isEqualTo(FAIL);
            assertThat(movingResult.getCurrentMovedIndex()).isEqualTo(1);
            assertThat(movingResult.isFinish()).isEqualTo(false);
        });
    }

}