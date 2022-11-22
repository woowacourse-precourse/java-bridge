package bridge;

import bridge.constant.GameCommand;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private List<String> bridge = Arrays.asList("D", "U", "D");
    private String upper = GameCommand.GO_UP.getGameCommand();
    private String lower = GameCommand.GO_DOWN.getGameCommand();

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void 다리_건너기_올바른_입력_테스트() {
        assertThat(bridgeGame.move(lower, "D")).isEqualTo(true);
    }

    @Test
    void 다리_건너기_올바른_입력_연속_테스트() {
        assertThat(bridgeGame.move(lower, "D")).isEqualTo(true);
        assertThat(bridgeGame.move(upper, "U")).isEqualTo(true);
        assertThat(bridgeGame.move(lower, "D")).isEqualTo(true);
    }

    @Test
    void 다리_건너기_틀린_입력_테스트() {
        assertThat(bridgeGame.move(lower, "U")).isEqualTo(false);
    }

    @Test
    void 다리_건너기_틀린_입력_연속_테스트() {
        assertThat(bridgeGame.move(lower, "D")).isEqualTo(true);
        assertThat(bridgeGame.move(upper, "D")).isEqualTo(false);
    }

    @Test
    void 게임_다시_시작_테스트_다시시작() {
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }

    @Test
    void 게임_다시_시작_테스트_종료() {
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }
}
