package bridge.service;


import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("유저가 잘 이동되는지 테스트")
    @Test
    public void moveTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        User user = new User();

        //when
        bridgeGame.move(bridge, user);

        //then
        assertThat(bridge.getLocation()).isEqualTo(1);
    }

    @DisplayName("유저가 다리 끝지점에 도착했는지 테스트")
    @Test
    public void moveCompleteTest() {
        //given
        Bridge bridge = new Bridge(List.of("U"));
        User user = new User();

        //when
        bridgeGame.move(bridge, user);

        //then
        assertThat(user.isSuccessComplete()).isEqualTo(true);
    }
}