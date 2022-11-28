package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @Nested
    @DisplayName("quit() 테스트")
    class Quit {
        @BeforeEach
        public void setUp() {
            bridgeGame = new BridgeGame(5);
        }
        @Test
        @DisplayName("quit()을 하면 게임이 끝난다.")
        public void quit() {
            bridgeGame.quit();
            boolean isEnd = bridgeGame.isEnd();
            assertThat(isEnd).isTrue();
        }
    }
}