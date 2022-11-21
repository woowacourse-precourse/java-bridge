package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Moving;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BridgeGameTest {

    private final static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @DisplayName("다리의 길이만큼 이동했기 때문에 더 이상 이동할 수 없음")
    @Test
    void canNotMoveContinueBecauseMoveEnd() {
        // given
        BridgeGame bridgeGame = new BridgeGame(bridgeNumberGenerator);
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
