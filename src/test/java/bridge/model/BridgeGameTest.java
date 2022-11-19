package bridge.model;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import bridge.domain.ResultFlag;
import bridge.domain.UpDownFlag;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        Bridge bridge = Bridge.of(List.of("D", "D", "D"));
        User user = new User();
        bridgeGame = new BridgeGame(user, bridge);
    }

    @Test
    @DisplayName("사용자가 다리를 모두 건너면 Success를 반환한다")
    void bridgeCrossOverSuccess() {
        // given
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.DOWN);
        // expect
        assertThat(bridgeGame.isCrossOver())
                .isEqualTo(ResultFlag.SUCCESS);
    }

    @Test
    @DisplayName("사용자가 다리를 아직 건너지 못하면 Nothing을 반환한다")
    void bridgeCrossOverNothing() {
        // given
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.DOWN);
        // expect
        assertThat(bridgeGame.isCrossOver())
                .isEqualTo(ResultFlag.NOTHING);
    }

    @Test
    @DisplayName("사용자가 다리를 아직 건너는데 실패하면 Fail을 반환한다.")
    void bridgeCrossOverFail() {
        // given
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.UP);
        // expect
        assertThat(bridgeGame.isCrossOver())
                .isEqualTo(ResultFlag.FAIL);
    }

    @Test
    @DisplayName("사용자가 중간에 잘못된 다리를 건너면 Fail을 반환한다.")
    void bridgeCrossOverFail2() {
        // given
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.UP);
        bridgeGame.move(UpDownFlag.DOWN);
        // expect
        assertThat(bridgeGame.isCrossOver())
                .isEqualTo(ResultFlag.FAIL);
    }

    @Test
    @DisplayName("사용자가 건넌 길이가 다리보다 길면 예외를 던진다.")
    void bridgeCrossOverByUserLengthOver() {
        // given
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.DOWN);
        bridgeGame.move(UpDownFlag.DOWN);
        // expect
        assertThatThrownBy(() -> bridgeGame.move(UpDownFlag.DOWN))
                .isInstanceOf(IllegalArgumentException.class);
    }
}