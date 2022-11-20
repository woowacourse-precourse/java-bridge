package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.enums.Direction;
import bridge.domain.enums.GameCommand;
import bridge.domain.enums.GameStatus;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bridge Game 테스트")
class BridgeGameTest {

    private static BridgeGame bridgeGame;

    @BeforeAll
    private static void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridgeGame = new BridgeGame(bridge);
    }

    @BeforeEach
    @DisplayName("bridge game 초기화")
    private void reset() {
        int tryCount = bridgeGame.getTryCount();
        bridgeGame.retry(GameCommand.RETRY);
        assertThat(bridgeGame.getTryCount()).isEqualTo(tryCount + 1);
    }

    @DisplayName("사용자가 칸을 이동하는 기능 테스트(LOSE)")
    @Test
    void moveResultLoseTest() {
        Direction direction = Direction.DOWN;
        GameStatus expected = GameStatus.LOSE;
        assertThat(bridgeGame.move(direction)).isEqualTo(expected);
    }

    @DisplayName("사용자가 칸을 이동하는 기능 테스트(KEEP_GOING)")
    @Test
    void moveResultKeepGoingTest() {
        Direction direction = Direction.UP;
        GameStatus expected = GameStatus.KEEP_GOING;
        assertThat(bridgeGame.move(direction)).isEqualTo(expected);
    }

    @DisplayName("사용자가 칸을 이동하는 기능 테스트(WIN")
    @Test
    void moveResultWinTest() {
        bridgeGame.move(Direction.UP);
        bridgeGame.move(Direction.DOWN);
        GameStatus status = bridgeGame.move(Direction.UP);
        GameStatus expected = GameStatus.WIN;
        assertThat(status).isEqualTo(expected);
    }
}
