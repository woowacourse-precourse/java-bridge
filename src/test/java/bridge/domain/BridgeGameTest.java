package bridge.domain;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.constant.Direction;
import bridge.dto.TrialResult;

class BridgeGameTest {

    @Test
    void 플레이어를_움직인다() {
        List<Direction> directions = List.of(UPPER, LOWER, UPPER, LOWER);
        BridgeGame bridgeGame = BridgeGame.fromDirections(directions);

        TrialResult trialResult = bridgeGame.move(UPPER.capitalLetter());

        assertThat(trialResult.wasSuccessful()).isTrue();
        assertThat(trialResult.getDirection()).isEqualTo(UPPER);
    }
}