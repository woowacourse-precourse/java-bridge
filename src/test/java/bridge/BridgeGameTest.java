package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("메소드 move 테스트")
    @Test
    void move() {
        List<String> bridge = Arrays.asList("U","D","U");
        bridgeGame.move(bridge,"U");
        assertThat(bridgeGame.getPlayerLocationIndex()).isEqualTo(0);
    }


}