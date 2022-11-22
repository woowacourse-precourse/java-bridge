package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.TestNumberGenerator;
import bridge.domain.Moving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BridgeGameTest {

    @DisplayName("다리의 길이만큼 이동했기 때문에 더 이상 이동할 수 없음")
    @Test
    void canNotMoveContinueBecauseMoveEnd() {
        // given
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        int bridgeSize = 3;
        bridgeGame.initialize(bridgeSize);
        
        // when
        IntStream.range(0, bridgeSize)
                .forEach(i -> bridgeGame.move(Moving.UP));
        boolean canMove = bridgeGame.canMoveContinue();

        // then
        assertFalse(canMove);
    }
}
