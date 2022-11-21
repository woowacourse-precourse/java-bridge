package bridge.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @Test
    void move() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "U"));
        assertThat(bridgeGame.move("U")).isTrue();
        assertThat(bridgeGame.move("D")).isTrue();
        assertThat(bridgeGame.move("D")).isFalse();
        assertThat(bridgeGame.toString()).contains(
                "[ O |   |   ]",
                "[   | O | X ]"
        );
    }

    @Test
    void retry() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "U"));
        bridgeGame.move("U");
        bridgeGame.retry();
        String result = bridgeGame.toString();
        boolean alive = bridgeGame.move("U");

        assertThat(result).contains("[]");
        assertThat(alive).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"UDUU, false", "UDD, true"}, delimiter = ',')
    void ongoing(String player, boolean isOngoing) {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "U"));
        for (int i = 0; i < player.length(); i++) {
            bridgeGame.move(player.substring(i, i + 1));
        }
        assertThat(bridgeGame.ongoing()).isEqualTo(isOngoing);
    }

    @Test
    void getRepeatCount() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "U"));
        bridgeGame.retry();
        bridgeGame.retry();

        assertThat(bridgeGame.getRepeatCount()).isEqualTo(3);
    }
}