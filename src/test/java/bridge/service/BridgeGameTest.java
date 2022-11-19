package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("move 테스트 (유저가 이동을 했지만, 아직까지 완료되지 않은 상태)")
    @Test
    public void moveTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        User user = new User();

        // when
        bridgeGame.move(bridge, user);

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(1);
    }

    @DisplayName("move 테스트 (유저가 이동을 하고, 게임을 성공적으로 마무리 한 경우)")
    @Test
    public void moveTest2() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        User user = new User();
        bridge.setNowIndex(2);

        // when
        bridgeGame.move(bridge, user);

        // then
        assertThat(user.isGameSuccess()).isEqualTo(true);
        assertThat(user.isGameSuccess()).isEqualTo(true);
    }

    @DisplayName("retry 테스트")
    @Test
    public void retryTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D", "D", "U"));
        User user = new User();
        bridge.setNowIndex(3);

        // when
        bridgeGame.retry(bridge, user);

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(0);
    }
}
