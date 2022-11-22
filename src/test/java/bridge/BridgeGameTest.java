package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("process : true 테스트")
    @Test
    public void processTrueTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        User user = new User();
        boolean isCorrect = true;

        // when
        bridgeGame.process(bridge, user, isCorrect);

        // then
        assertThat(bridge.getCurrentBlock()).isEqualTo(1);
    }
}