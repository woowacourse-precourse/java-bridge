package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static final boolean CORRECT_BRIDGE = true;
    private static final boolean WRONG_BRIDGE = false;
    private static final boolean END_GAME = true;
    private static final boolean GAME_ING = false;

    List<String> bridge;
    BridgeGame game;

    @BeforeEach
    void init() {
        bridge = List.of("U", "U", "U", "D", "D");
        game = new BridgeGame();
    }

    @Test
    void 다리_이동_성공_여부_테스트() {
        List<String> inputMoving = List.of("U", "U", "U", "D", "D");
        for (int i = 0; i < inputMoving.size(); i++) {
            game.move(bridge, inputMoving.get(i));
        }
        assertThat(game.getMovingResult()).isEqualTo(List.of(CORRECT_BRIDGE, CORRECT_BRIDGE, CORRECT_BRIDGE, CORRECT_BRIDGE, CORRECT_BRIDGE));
    }

    @Test
    void 다리_이동_실패_시_해당_지점까지_성공_여부_테스트() {
        List<String> inputMoving = List.of("U", "U", "D");
        for (int i = 0; i < inputMoving.size(); i++) {
            game.move(bridge, inputMoving.get(i));
        }
        assertThat(game.getMovingResult()).isEqualTo(List.of(CORRECT_BRIDGE, CORRECT_BRIDGE, WRONG_BRIDGE));
    }

    @Test
    void 다리를_끝까지_건너는_경우_종료_여부_테스트() {
        List<String> inputMoving = List.of("U", "U", "U", "D", "D");
        for (int i = 0; i < inputMoving.size(); i++) {
            game.move(bridge, inputMoving.get(i));
        }
        assertThat(game.isEnd(bridge)).isEqualTo(END_GAME);
    }

    @Test
    void 종료_시_게임_상태_여부_테스트() {
        game.end();
        assertThat(game.isEnd(bridge)).isEqualTo(END_GAME);
    }

    @Test
    void 재시작_시_게임_상태_여부_테스트() {
        game.retry();
        assertThat(game.isEnd(bridge)).isEqualTo(GAME_ING);
    }
}
