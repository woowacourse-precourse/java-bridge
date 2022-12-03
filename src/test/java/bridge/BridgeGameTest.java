package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("U 또는 D로 움직이는지 확인")
    void testMove() {

        bridgeGame.move("U", "U");
        bridgeGame.move("D","D");
        bridgeGame.move("U","D");

        System.out.println(bridgeGame.toString());
    }

    @Test
    @DisplayName("R을 누르면 재시작이 되고 재시도 숫자가 오르는지 확인")
    void testRetry() {
        int t = bridgeGame.retry(0, "R");
        assertThat(t).isEqualTo(1);
    }
}
