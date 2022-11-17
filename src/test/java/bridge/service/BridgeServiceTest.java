package bridge.service;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import bridge.domain.BridgeFlag;
import bridge.domain.UpDownFlag;
import bridge.domain.User;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeServiceTest {
    BridgeService bridgeService;
    Bridge bridge;
    User user;

    @BeforeEach
    void setUp() {
        bridgeService = new BridgeService(new BridgeMaker(new BridgeRandomNumberGenerator()), new InputView(),
                new OutputView());
        bridge = Bridge.of(List.of("D", "D", "D"));
        user = new User();
    }

    @Test
    @DisplayName("사용자가 다리를 모두 건너면 Success를 반환한다")
    void bridgeCrossOverSuccess() {
        // given
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.DOWN);
        // expect
        assertThat(bridgeService.getGameStatus(bridge, user))
                .isEqualTo(BridgeFlag.SUCCESS);
    }

    @Test
    @DisplayName("사용자가 다리를 아직 건너지 못하면 Nothing을 반환한다")
    void bridgeCrossOverNothing() {
        // given
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.DOWN);
        // expect
        assertThat(bridgeService.getGameStatus(bridge, user))
                .isEqualTo(BridgeFlag.NOTHING);
    }

    @Test
    @DisplayName("사용자가 다리를 아직 건너는데 실패하면 Fail을 반환한다.")
    void bridgeCrossOverFail() {
        // given
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.UP);
        // expect
        assertThat(bridgeService.getGameStatus(bridge, user))
                .isEqualTo(BridgeFlag.FAIL);
    }

    @Test
    @DisplayName("사용자가 중간에 잘못된 다리를 건너면 Fail을 반환한다.")
    void bridgeCrossOverFail2() {
        // given
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.UP);
        user.move(UpDownFlag.DOWN);
        // expect
        assertThat(bridgeService.getGameStatus(bridge, user))
                .isEqualTo(BridgeFlag.FAIL);
    }

    @Test
    @DisplayName("사용자가 건넌 길이가 다리보다 길면 예외를 던진다.")
    void bridgeCrossOverByUserLengthOver() {
        // given
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.DOWN);
        user.move(UpDownFlag.DOWN);
        // expect
        assertThatThrownBy(() -> bridgeService.getGameStatus(bridge, user))
                .isInstanceOf(IllegalArgumentException.class);
    }
}