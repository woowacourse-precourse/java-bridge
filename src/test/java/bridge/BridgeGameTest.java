package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static final boolean END_GAME = true;

    List<String> bridge;

    @BeforeEach
    void init() {
        bridge = List.of("U", "U", "U", "D", "D");
    }

    @Test
    void 다리_이동_성공_여부_테스트() {
        List<String> inputMoving = List.of("U", "U", "D");
        BridgeGame game = new BridgeGame();
        for (int i = 0; i < inputMoving.size(); i++) {
            game.move(bridge, inputMoving.get(i));
        }
        assertThat(game.getMovingResult()).isEqualTo(List.of(true, true, false));
    }

    @Test
    void 다리를_끝까지_건너는_경우_종료_여부_테스트() {
        List<String> inputMoving = List.of("U", "U", "U", "D", "D");
        BridgeGame game = new BridgeGame();
        for (int i = 0; i < inputMoving.size(); i++) {
            game.move(bridge, inputMoving.get(i));
        }
        assertThat(game.isEnd(bridge)).isEqualTo(END_GAME);
    }
}
