package bridge.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private String up;
    private String down;

    @BeforeEach
    void setUp() {
        List<String> bridge = List.of("U", "D", "D");
        bridgeGame = new BridgeGame(bridge);
        up = "U";
        down = "D";
    }

    @Test
    void 계속_진행_테스트() {
        int expected = Status.CONTINUE.getNumber();
        assertThat(bridgeGame.move(up)).isEqualTo(expected);
    }

    @Test
    void 실패_테스트() {
        int expected = Status.FAIL.getNumber();
        assertThat(bridgeGame.move(down)).isEqualTo(expected);
    }

    @Test
    void 성공_테스트() {
        int expected = Status.SUCCESS.getNumber();
        bridgeGame.move(up);
        bridgeGame.move(down);
        assertThat(bridgeGame.move(down)).isEqualTo(expected);
    }
}