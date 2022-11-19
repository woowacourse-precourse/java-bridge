package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Test
    void 다리_이동_성공_여부_테스트() {
        List<String> bridge = List.of("U", "U", "U", "D", "D");
        List<String> inputMoving = List.of("U", "U", "D");
        BridgeGame game = new BridgeGame();
        for (int i = 0; i < inputMoving.size(); i++) {
            game.move(bridge, inputMoving.get(i));
        }
        assertThat(game.getMovingResult()).isEqualTo(List.of(true, true, false));
    }
}
