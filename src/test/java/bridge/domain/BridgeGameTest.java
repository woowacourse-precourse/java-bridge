package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Nested
    @DisplayName("게임이")
    class If_game {

        @Test
        @DisplayName("끝났다면 true 리턴을 테스트")
        void end_then_return_true() {
            // given
            Bridge bridge = new Bridge(List.of("U", "U", "U"));
            User user = new User();
            for (int stepForward = 0; stepForward < bridge.getSize(); stepForward++) {
                user.stepForward();
            }
            BridgeGame bridgeGame = new BridgeGame(bridge, user);

            // when
            boolean end = bridgeGame.isEnd();

            // then
            assertThat(end).isTrue();
        }

        @Test
        @DisplayName("끝나지 않았다면 false 리턴을 테스트")
        void does_not_end_then_return_false() {
            // given
            Bridge bridge = new Bridge(List.of("U", "U", "U"));
            User user = new User();
            BridgeGame bridgeGame = new BridgeGame(bridge, user);

            // when
            boolean end = bridgeGame.isEnd();

            // then
            assertThat(end).isFalse();
        }
    }
}