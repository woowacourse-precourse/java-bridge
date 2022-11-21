package bridge.controller;


import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameControllerTest {
    private final BridgeGameController bridgeGameController = new BridgeGameController();

    @DisplayName("한 단계 통과 테스트")
    @Test
    public void runPassOrFailCaseTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        User user = new User();
        boolean pass = true;

        //when
        bridgeGameController.runPassOrFailCase(pass, bridge, user);

        //then
        assertThat(bridge.getLocation()).isEqualTo(1);
    }

    @DisplayName("통과 테스트")
    @Test
    public void runSuccessCompleteTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        User user = new User();
        boolean pass = true;
        bridgeGameController.runPassOrFailCase(pass, bridge, user);
        bridgeGameController.runPassOrFailCase(pass, bridge, user);

        //when
        bridgeGameController.runPassOrFailCase(pass, bridge, user);

        //then
        assertThat(user.isSuccessComplete()).isEqualTo(true);
        assertThat(user.isGameOver()).isEqualTo(true);
    }

    @DisplayName("통과 실패 후 종료 테스트")
    @Test
    public void runFailCaseWithEndTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        User user = new User();
        String gameCommand = "Q";

        //when
        bridgeGameController.runFailCase(bridge, user, gameCommand);

        //then
        assertThat(user.isSuccessComplete()).isEqualTo(false);
    }

    @DisplayName("통과 실패 후 재시작 테스트")
    @Test
    public void runFailCaseWithRetryTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        User user = new User();
        String gameCommand = "R";
        bridge.increaseLocation();

        //when
        bridgeGameController.runFailCase(bridge, user, gameCommand);

        //then
        assertThat(bridge.getLocation()).isEqualTo(0);
    }
}