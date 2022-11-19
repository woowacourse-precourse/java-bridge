package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private Bridge bridge;
    private User user;

    @BeforeEach
    void init() {
        bridge = new Bridge(List.of("U", "U", "U"));
        user = new User();
        bridgeGame = new BridgeGame(bridge, user);
    }

    @Nested
    @DisplayName("게임이")
    class If_game {

        @Test
        @DisplayName("끝났다면 true 리턴을 테스트")
        void end_then_return_true() {
            // given
            for (int stepForward = 0; stepForward < bridge.getSize(); stepForward++) {
                user.stepForward();
            }

            // when
            boolean end = bridgeGame.isEnd();

            // then
            assertThat(end).isTrue();
        }

        @Test
        @DisplayName("끝나지 않았다면 false 리턴을 테스트")
        void does_not_end_then_return_false() {
            // given

            // when
            boolean end = bridgeGame.isEnd();

            // then
            assertThat(end).isFalse();
        }
    }

    @Nested
    @DisplayName("게임 재시작 커맨드가")
    class If_game_restart_command_is {

        @Test
        @DisplayName("R이면 true를 반환한다")
        void R_then_return_true() {
            // given
            String command = "R";

            // when
            Boolean isRetry = bridgeGame.retry(command);

            // then
            assertThat(isRetry).isTrue();

        }

        @Test
        @DisplayName("Q면 false를 반환한다")
        void Q_then_return_false() {
            // given
            String command = "Q";

            // when
            Boolean isRetry = bridgeGame.retry(command);

            // then
            assertThat(isRetry).isFalse();
        }
    }
}