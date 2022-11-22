package bridge.domain;

import static bridge.constant.GameStatus.END;
import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.GameStatus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeRefereeTest {
    BridgeReferee bridgeReferee = new BridgeReferee(List.of(UPPER_SIDE, LOWER_SIDE, UPPER_SIDE));

    @DisplayName("이동 방향이 맞으면 이동하고 아니면 멈춘 후, 현재 게임 상태를 반환한다.")
    @Nested
    class GoIfCorrectAndReturnStatus {

        @DisplayName("방향이 맞고, 아직 갈 길이 남은 경우 -> ON_WAY 반환")
        @Test
        void should_ReturnOnWay_When_InputCorrectMoving() {
            String moving = UPPER_SIDE;
            GameStatus gameStatusAfterMoving = bridgeReferee.judge(moving);
            assertThat(gameStatusAfterMoving).isEqualTo(ON_WAY);
        }

        @DisplayName("방향이 틀린 경우 -> FAIL 반환")
        @Test
        void should_ReturnFail_When_InputIncorrectMoving() {
            String moving = LOWER_SIDE;
            GameStatus gameStatusAfterMoving = bridgeReferee.judge(moving);
            assertThat(gameStatusAfterMoving).isEqualTo(FAIL);
        }

        @DisplayName("방향이 맞고, 다리를 끝까지 건넌 경우 -> END 반환")
        @Test
        void should_ReturnEnd_When_InputCorrectMovingAndCrossBridgeCompletely() {
            bridgeReferee.judge(UPPER_SIDE);
            bridgeReferee.judge(LOWER_SIDE);
            String moving = UPPER_SIDE;
            GameStatus gameStatusAfterMoving = bridgeReferee.judge(moving);
            assertThat(gameStatusAfterMoving).isEqualTo(END);
        }
    }

    @DisplayName("다리를 완전히 건넜는지 확인한다.")
    @Nested
    class CheckIsCrossBridgeCompletely {

        @DisplayName("현재 위치와 다리의 길이가 같을 때 -> True 반환")
        @Test
        void should_ReturnTrue_When_CrossBridgeCompletely() {
            bridgeReferee.judge(UPPER_SIDE);
            bridgeReferee.judge(LOWER_SIDE);
            bridgeReferee.judge(UPPER_SIDE);
            boolean isCrossCompletely = bridgeReferee.isCrossCompletely();
            assertThat(isCrossCompletely).isTrue();
        }

        @DisplayName("현재 위치가 다리의 길이보다 작을 때 -> False 반환")
        @Test
        void should_ReturnFalse_When_IsCrossingYet() {
            bridgeReferee.judge(UPPER_SIDE);
            bridgeReferee.judge(LOWER_SIDE);
            bridgeReferee.judge(LOWER_SIDE);
            boolean isCrossCompletely = bridgeReferee.isCrossCompletely();
            assertThat(isCrossCompletely).isFalse();
        }
    }

    @DisplayName("위치를 초기화한다.")
    @Test
    void should_ResetLocationToZero_When_Request() {
        bridgeReferee.judge(UPPER_SIDE);
        bridgeReferee.resetLocation();
        GameStatus gameStatusAfterMoving = bridgeReferee.judge(LOWER_SIDE);
        assertThat(gameStatusAfterMoving).isEqualTo(FAIL);
    }
}