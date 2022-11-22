package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.game.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;
    int bridgeSize;

    @BeforeEach
    void setUp() {
        bridgeSize = 3;
        bridgeGame = new BridgeGame(new Bridge(bridgeSize));
    }

    @Nested
    @DisplayName("게임의 상태 변환 테스트")
    class StateTransition {
        @Test
        @DisplayName("R 입력하면 게임 상태는 PLAYING")
        void transitionToPLAYING() {
            String cmdRetry = "R";
            bridgeGame.transitionTo(cmdRetry);
            assertThat(bridgeGame.onPlay()).isEqualTo(true);
        }

        @Test
        @DisplayName("Q 입력하면 게임 상태는 QUIT_PLAYING")
        void transitionToQUIT_PLAYING() {
            String cmdQuit = "Q";
            bridgeGame.transitionTo(cmdQuit);
            assertThat(bridgeGame.onPlay()).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("Player 움직임 관련 테스트")
    class PlayerMoveTest{
        @BeforeEach
        void setUp(){
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("D");
        }

        @Test
        @DisplayName("다리 사이즈만큼 다 건넜는지 확인한다")
        void hasPlayerCrossed(){
            assertThat(bridgeGame.playerHasCrossed()).isEqualTo(true);
        }

        @Test
        @DisplayName("Player 움직임 리스트 확인한다")
        void move() {
            assertThat(bridgeGame.getPlayersMove()).containsExactly("U", "U", "D");
        }

        @Test
        @DisplayName("retry 시, players move 리스트가 비는지 확인한다")
        void retry(){
            bridgeGame.retry();
            assertThat(bridgeGame.getPlayersMove().size()).isEqualTo(0);
        }
    }

}