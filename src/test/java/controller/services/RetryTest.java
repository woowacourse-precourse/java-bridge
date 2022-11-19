package controller.services;

import model.Bridge;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RetryTest {

    @Test
    @DisplayName("R을 받았을 시 0을 반환.")
    void retryGame() {
        User user = new User();
        Bridge bridge = new Bridge(List.of("NULL"));
        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        assertThat(bridgeGame.retry("R")).isEqualTo(0);
    }

    @Test
    @DisplayName("Q을 받았을 시 -1을 반환.")
    void quitGame() {
        User user = new User();
        Bridge bridge = new Bridge(List.of("NULL"));
        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        assertThat(bridgeGame.retry("Q")).isEqualTo(-1);
    }
}
