package controller.services;

import model.Bridge;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RetryTest {
    @Test
    @DisplayName("R을 입력받았을 시 0을 반환.")
    void retryGame() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("")), new User());
        assertThat(bridgeGame.retry("R")).isEqualTo(0);
    }

    @Test
    @DisplayName("Q을 입력받았을 시 -1을 반환.")
    void quitGame() {
        BridgeGame bridgeGame = new BridgeGame(new Bridge(List.of("")), new User());
        assertThat(bridgeGame.retry("Q")).isEqualTo(-1);
    }
}
