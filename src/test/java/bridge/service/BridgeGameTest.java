package bridge.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("사용자가 다리를 건너는 경우")
    @Nested
    class moveTest {
        List<String> bridgeInfo = List.of("U", "D", "U");

        @BeforeEach
        void beforeEach() {
            BridgeGame.userDirection.clear();
        }

        @DisplayName("건너는 데 성공한 경우")
        @Test
        void success() {
            String direction = "U";
            assertThat(bridgeGame.move(bridgeInfo, direction)).isEqualTo(true);
        }

        @DisplayName("건너는 데 실패한 경우")
        @Test
        void fail() {
            String direction = "D";
            assertThat(bridgeGame.move(bridgeInfo, direction)).isEqualTo(false);
        }

    }




}
