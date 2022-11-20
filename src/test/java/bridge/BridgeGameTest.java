package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @Test
    void testMove() {

        bridgeGame.move("U", "U");
        bridgeGame.move("D","D");
        bridgeGame.move("U","D");

        System.out.println(bridgeGame.toString());
    }

    @Test
    void testRetry() {
        int t = bridgeGame.retry(0, "R");
        assertThat(t).isEqualTo(1);
    }
}
