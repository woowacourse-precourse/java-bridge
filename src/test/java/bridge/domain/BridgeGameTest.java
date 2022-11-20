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

    @Test
    void 게임이_끝났는지_알_수_있다() {
        BridgeGame bridgeGame = BridgeGame.fromDirections(List.of(UPPER));

        bridgeGame.move(UPPER.capitalLetter());
        assertThat(bridgeGame.isFinished()).isTrue();
    }

    @Test
    void 게임이_아직_끝나지_않았다() {
        BridgeGame bridgeGame = BridgeGame.fromDirections(List.of(UPPER));

        assertThat(bridgeGame.isFinished()).isFalse();
    }

    @Test
    void 게임을_재시도한다() {
        BridgeGame bridgeGame = BridgeGame.fromDirections(List.of(UPPER));

        bridgeGame.move(UPPER.capitalLetter());
        assertThat(bridgeGame.isFinished()).isTrue();

        bridgeGame.retry();
        assertThat(bridgeGame.isFinished()).isFalse();
    }
}