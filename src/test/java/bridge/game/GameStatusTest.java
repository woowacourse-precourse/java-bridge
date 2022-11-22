package bridge.game;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameStatusTest {

    GameStatus gameStatus;

    @BeforeEach
    void setUp() {
        gameStatus = new GameStatus();
    }

    @DisplayName("재시도")
    @Test
    void testRetry() {
        int tryCount = gameStatus.getTryCount();
        gameStatus.restart();

        assertThat(gameStatus).extracting("tryCount")
                              .isEqualTo(tryCount + 1);
    }

    @DisplayName("위 칸으로 이동")
    @Test
    void testGoUp() {
        gameStatus.move(Direction.UP);

        String map = "[ O ]\n[   ]";
        assertThat(gameStatus.getBridgeStatus()).isEqualTo(map);
    }

    @DisplayName("아래 칸으로 이동")
    @Test
    void testGoDown() {
        gameStatus.move(Direction.DOWN);

        String map = "[   ]\n[ O ]";
        assertThat(gameStatus.getBridgeStatus()).isEqualTo(map);
    }

    @DisplayName("위 칸으로 이동 실패")
    @Test
    void testGoUpFail() {
        gameStatus.makeFail(Direction.UP);

        String map = "[ X ]\n[   ]";
        assertThat(gameStatus.getBridgeStatus()).isEqualTo(map);
    }

    @DisplayName("아래 칸으로 이동 실패")
    @Test
    void testGoDownFail() {
        gameStatus.makeFail(Direction.DOWN);

        String map = "[   ]\n[ X ]";
        assertThat(gameStatus.getBridgeStatus()).isEqualTo(map);
    }

}
