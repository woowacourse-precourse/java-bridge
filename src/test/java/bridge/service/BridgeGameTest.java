package bridge.service;

import bridge.vo.Bridge;
import bridge.vo.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeGameTest {
    public static final String UP = Step.U.toString();
    public static final String DOWN = Step.D.toString();
    private final BridgeGame bridgeGame = new BridgeGame();

    @Nested
    @DisplayName("차례에 해당하는 칸의 정답과 사용자가 선택한 칸이 일치하는 지 비교하는 move 메서드")
    class move {
        @Test
        @DisplayName("호출할 때마다 다리를 한 칸씩 앞으로 이동하면서 입력값과 값을 비교한다.")
        void givenInputAndBridge_whenMoving_thenReturnsMatchingYesOrNo() {
            //given
            List<Step> steps = Step.from(List.of(UP, DOWN, UP, UP, DOWN));
            Iterator<Step> bridgeIter = getBridgeIter(steps);

            //when
            for (Step step : steps) {
                assertTrue(bridgeGame.move(step, bridgeIter.next()).isCorrect());
            }
        }

        @Test
        @DisplayName("입력값이 해당 칸의 정답과 일치하지 않으면 false 값을 리턴한다.")
        void givenWrongInputAndBridge_whenMoving_thenReturnsFalse() {
            //given
            List<Step> steps = Step.from(List.of(DOWN, UP, UP, DOWN));
            Iterator<Step> bridgeIter = getBridgeIter(steps);

            //when.isCorrect()
            assertTrue(bridgeGame.move(Step.D, bridgeIter.next()).isCorrect());
            assertTrue(bridgeGame.move(Step.U, bridgeIter.next()).isCorrect());
            assertFalse(bridgeGame.move(Step.D, bridgeIter.next()).isCorrect());
            assertFalse(bridgeGame.move(Step.U, bridgeIter.next()).isCorrect());
        }
    }

    private static Iterator<Step> getBridgeIter(List<Step> steps) {
        Bridge bridge = new Bridge(steps);
        return bridge.toIterator();
    }
}