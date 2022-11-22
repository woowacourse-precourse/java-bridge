package bridge.domain;

import static bridge.constant.GameStatus.END;
import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeDrawerTest {
    BridgeDrawer bridgeDrawer;

    @BeforeEach
    void initBridgeDrawer() {
        bridgeDrawer = new BridgeDrawer();
    }

    @DisplayName("한 턴의 이동에 대한 현황을 기록한다.")
    @Nested
    class RecordMoving {

        @DisplayName("위 방향 이동에 성공")
        @Test
        void should_RecordCorrectMoving_When_SuccessToMove() {
            String moving = UPPER_SIDE;
            GameStatus gameStatusAfterMoving = ON_WAY;
            bridgeDrawer.record(moving, gameStatusAfterMoving);
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[ O ]" + "\n" + "[   ]");
        }

        @DisplayName("아래 방향 이동에 실패")
        @Test
        void should_RecordWrongMoving_When_FailToMove() {
            String moving = LOWER_SIDE;
            GameStatus gameStatusAfterMoving = FAIL;
            bridgeDrawer.record(moving, gameStatusAfterMoving);
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[   ]" + "\n" + "[ X ]");
        }

        @DisplayName("위, 아래 방향 이동 성공 후, 아래 방향 이동에 실패")
        @Test
        void should_RecordWrongMoving_When_FailToMoveAfterSuccessTwice() {
            bridgeDrawer.record(UPPER_SIDE, ON_WAY);
            bridgeDrawer.record(LOWER_SIDE, ON_WAY);
            bridgeDrawer.record(LOWER_SIDE, FAIL);
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[ O |   |   ]" + "\n" + "[   | O | X ]");
        }

        @DisplayName("위, 아래 방향 이동 성공 후, 아래 방향 이동에 성공하며 다리를 모두 건너기 완료")
        @Test
        void should_RecordCorrectMoving_When_CrossBridgeCompletely() {
            bridgeDrawer.record(UPPER_SIDE, ON_WAY);
            bridgeDrawer.record(LOWER_SIDE, ON_WAY);
            bridgeDrawer.record(LOWER_SIDE, END);
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[ O |   |   ]" + "\n" + "[   | O | O ]");
        }
    }

    @DisplayName("이동 기록을 되돌린다.")
    @Nested
    class Reset {

        @DisplayName("이동 1회 성공 후 이동 실패한 경우")
        @Test
        void should_DeleteRecordOfWrongMoving_When_FailToMoveAfterSuccessOnce() {
            bridgeDrawer.record(UPPER_SIDE, ON_WAY);
            bridgeDrawer.record(LOWER_SIDE, FAIL);
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[ O |   ]" + "\n" + "[   | X ]");
            bridgeDrawer.reset();
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[]" + "\n" + "[]");
        }

        @DisplayName("시작 후 바로 이동 실패한 경우")
        @Test
        void should_DeleteRecordOfWrongMoving_When_FailToMoveRightAfterStart() {
            bridgeDrawer.record(LOWER_SIDE, FAIL);
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[   ]" + "\n" + "[ X ]");
            bridgeDrawer.reset();
            assertThat(bridgeDrawer.getPicture()).isEqualTo("[]" + "\n" + "[]");
        }
    }
}