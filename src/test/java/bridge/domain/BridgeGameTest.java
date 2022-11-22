package bridge.domain;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import bridge.constant.Direction;

class BridgeGameTest {

    @ParameterizedTest
    @CsvSource(value = {"UPPER,true", "LOWER,false"}, delimiter = ',')
    void 위나_아래로_이동한다(Direction direction, boolean expected) {
        BridgeGame bridgeGame = BridgeGame.fromDirections(List.of(UPPER, LOWER, UPPER, LOWER));

        assertThat(bridgeGame.move(direction)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"UPPER,true", "LOWER,false"}, delimiter = ',')
    void 다리를_모두_건넜는지_알_수_있다(Direction direction, boolean expected) {
        BridgeGame bridgeGame = BridgeGame.fromDirections(List.of(UPPER));
        bridgeGame.move(direction);

        assertThat(bridgeGame.isFinished()).isEqualTo(expected);
    }

    @Test
    void 게임을_재시도한다() {
        BridgeGame bridgeGame = BridgeGame.fromDirections(List.of(UPPER));

        bridgeGame.move(UPPER);
        assertThat(bridgeGame.isFinished()).isTrue();

        bridgeGame.retry();
        assertThat(bridgeGame.isFinished()).isFalse();
    }

    @Test
    void 시도_횟수를_알_수_있다() {
        BridgeGame bridgeGame = BridgeGame.fromDirections(List.of(UPPER, LOWER));
        bridgeGame.retry();
        bridgeGame.retry();

        assertThat(bridgeGame.getTrialCount()).isEqualTo(3);
    }
}