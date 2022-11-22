package bridge;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    public void setUp() {
        bridgeGame = new BridgeGame(Arrays.asList("U", "U", "D"), 3);
    }

    @AfterEach
    public void after() {
        bridgeGame.retry();
    }

    @DisplayName("사용자 칸과 정답이 맞을 경우 이동이 가능하다.")
    @Test
    public void moveTest() {
        Assertions.assertEquals(bridgeGame.move("U"), 0);
    }

    @DisplayName("사용자 칸과 정답이 다를 경우 이동할 수 없다.")
    @Test
    public void notMoveTest() {
        Assertions.assertEquals(bridgeGame.move("D"), -1);
    }

    @DisplayName("다리 끝에 도착하게 되면 1을 리턴한다.")
    @Test
    public void moveEndBridgeTest() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        Assertions.assertEquals(bridgeGame.move("D"), 1);
    }

    @DisplayName("사용자가 게임을 다시 시작하면 필드들을 초기화한다.")
    @Test
    public void retryBridgeGame() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        Assertions.assertEquals(bridgeGame.getUp(), "[ O |   |");
        Assertions.assertEquals(bridgeGame.getDown(), "[   | X |");
        bridgeGame.retry();
        Assertions.assertEquals(bridgeGame.getUp(), "[");
        Assertions.assertEquals(bridgeGame.getDown(), "[");
    }

    @DisplayName("다리 끝에 도착하면 성공")
    @Test
    public void gameResultBySuccess() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        Assertions.assertEquals(bridgeGame.isSuccess(), "성공");
    }
}
