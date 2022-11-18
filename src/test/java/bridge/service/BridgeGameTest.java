package bridge.service;

import bridge.vo.Bridge;
import bridge.vo.BridgeStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @Nested
    @DisplayName("차례에 해당하는 칸의 정답과 사용자가 선택한 칸이 일치하는 지 비교하는 move 메서드")
    class move {
        @Test
        @DisplayName("호출할 때마다 다리를 한 칸씩 앞으로 이동하면서 입력값과 값을 비교한다.")
        void givenInputAndBridge_whenMoving_thenReturnsMatchingYesOrNo() {
            //given
            Iterator<BridgeStep> bridgeIter = getBridgeIter();

            //when
            Assertions.assertTrue(bridgeGame.move(BridgeStep.U, bridgeIter));
            Assertions.assertTrue(bridgeGame.move(BridgeStep.D, bridgeIter));
            Assertions.assertTrue(bridgeGame.move(BridgeStep.U, bridgeIter));
            Assertions.assertTrue(bridgeGame.move(BridgeStep.U, bridgeIter));
            Assertions.assertTrue(bridgeGame.move(BridgeStep.D, bridgeIter));
        }

        @Test
        @DisplayName("입력값이 해당 칸의 정답과 일치하지 않으면 false 값을 리턴한다.")
        void givenWrongInputAndBridge_whenMoving_thenReturnsFalse() {
            //given
            Iterator<BridgeStep> bridgeIter = getBridgeIter();

            //when
            Assertions.assertTrue(bridgeGame.move(BridgeStep.U, bridgeIter));
            Assertions.assertTrue(bridgeGame.move(BridgeStep.D, bridgeIter));
            Assertions.assertTrue(bridgeGame.move(BridgeStep.U, bridgeIter));
            Assertions.assertFalse(bridgeGame.move(BridgeStep.D, bridgeIter));
            Assertions.assertFalse(bridgeGame.move(BridgeStep.U, bridgeIter));
        }
    }

    private static Iterator<BridgeStep> getBridgeIter() {
        Bridge bridge = new Bridge(BridgeStep.from(List.of("U", "D", "U", "U", "D")));
        return bridge.toIterator();
    }
}