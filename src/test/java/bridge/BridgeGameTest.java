package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class BridgeGameTest {
    @Test
    void moveTest() {
        BridgeGame tester = new BridgeGame(List.of("U", "D", "D", "U", "D"));

        assertThat(tester.move("U", "U")).isEqualTo(true);
    }

    @Test
    void retryTest() {
        BridgeGame tester = new BridgeGame(List.of("U", "D", "D", "U", "D"));

        assertThat(tester.retry("Q")).isEqualTo(false);
    }
}

