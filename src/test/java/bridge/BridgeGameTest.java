package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("move_모든_움직임_유효")
    @Test
    void move_모든_움직임_유효() {
        List<String> bridge = Arrays.asList("U", "D", "U", "D", "U", "D", "U", "U", "U");

        for (String section : bridge) {
            assertThat(bridgeGame.move(section, bridge)).isEqualTo(true);
        }
    }

    @DisplayName("move_모든_움직임_무효")
    @Test
    void move_모든_움직임_무효() {
        List<String> bridge = Arrays.asList("U", "D", "U", "D", "U", "D", "U", "U", "U");
        List<String> opposite = Arrays.asList("D", "U", "D", "U", "D", "U", "D", "D", "D");

        for(int i=0;i<bridge.size();i++) {
            assertThat(bridgeGame.move(opposite.get(i), bridge)).isEqualTo(false);
        }
    }

    @DisplayName("재시도")
    @Test
    void 재시도() {
        List<String> userRoute = new ArrayList<>(Arrays.asList("U","D","D"));
        assertThat(userRoute.size()).isEqualTo(3);

        bridgeGame.retry(userRoute);

        assertThat(userRoute.size()).isEqualTo(0);
    }

    @DisplayName("재시도_후_움직임")
    @Test
    void 재시도_후_움직임() {
        List<String> bridge = Arrays.asList("U", "D", "U", "D", "U", "D", "U", "U", "U");

        for(int i=0;i<5;i++) {
            assertThat(bridgeGame.move(bridge.get(i), bridge)).isEqualTo(true);
        }

        assertThat(bridgeGame.move("U", bridge)).isEqualTo(false);

        List<String> userRoute = new ArrayList<>(Arrays.asList("U","D","D"));
        bridgeGame.retry(userRoute);

        assertThat(userRoute.size()).isEqualTo(0);

        for (String section : bridge) {
            assertThat(bridgeGame.move(section, bridge)).isEqualTo(true);
        }
    }
}