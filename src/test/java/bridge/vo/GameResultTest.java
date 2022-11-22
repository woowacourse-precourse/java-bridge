package bridge.vo;

import bridge.dto.TryCountDto;
import bridge.vo.enums.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameResultTest {

    public static final String UP = Step.U.toString();
    public static final String DOWN = Step.D.toString();

    @Nested
    @DisplayName("GameResult 객체와 주어진 다리를 이용해 완주 여부를 판단하는 isFinishedFrom 메서드")
    class IsFinishedFromTest {
        @Test
        @DisplayName("GameResult에서 건넌 다리 개수가 주어진 다리의 개수보다 짧으면 완주하지 못한 것이다.")
        void givenGameResultShorterThanBridge_whenRunningIsFinished_thenReturnsFalse() {
            //given
            Bridge bridge = new Bridge(Step.from(List.of(UP, DOWN, UP, DOWN)));
            GameResult gameResult = new GameResult(List.of(
                    new StepResult(Step.U, true),
                    new StepResult(Step.D, true),
                    new StepResult(Step.U, true)
            ), new TryCountDto());

            //when && then
            assertFalse(gameResult.isFinishedFrom(bridge));
        }

        @Test
        @DisplayName("건넌 다리 개수와 주어진 다리의 개수와 같지만, 마지막으로 건넌 다리의 결과가 실패일 경우 완주하지 못한 것이다.")
        void givenGameResultEqualsBridgeButFailedLast_whenRunningIsFinished_thenReturnsFalse() {
            Bridge bridge = new Bridge(Step.from(List.of(UP, DOWN, UP, DOWN)));
            GameResult gameResult = new GameResult(List.of(
                    new StepResult(Step.U, true),
                    new StepResult(Step.D, true),
                    new StepResult(Step.U, true),
                    new StepResult(Step.D, false)
            ), new TryCountDto());

            //when && then
            assertFalse(gameResult.isFinishedFrom(bridge));
        }

        @Test
        @DisplayName("건넌 다리 개수와 주어진 다리의 개수가 같고, 마지막까지 성공했다면 완주한 것이다.")
        void givenGameResultEqualsBridgeAndSucceedLast_whenRunningIsFinished_thenReturnsTrue() {
            Bridge bridge = new Bridge(Step.from(List.of(UP, DOWN, UP, DOWN)));
            GameResult gameResult = new GameResult(List.of(
                    new StepResult(Step.U, true),
                    new StepResult(Step.D, true),
                    new StepResult(Step.U, true),
                    new StepResult(Step.D, true)
            ), new TryCountDto());

            //when && then
            assertTrue(gameResult.isFinishedFrom(bridge));
        }
    }
}