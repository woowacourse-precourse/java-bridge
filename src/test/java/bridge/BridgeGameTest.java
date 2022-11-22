package bridge;

import bridge.data.Direction;
import bridge.mock.MockBridgeNumberGenerator;
import bridge.presentation.PlayerMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeGameTest {

    private BridgeGame bridgeGame;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;
    private PlayerMap playerMap;
    private List<String> bridge;
    private final int size = 6;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeNumberGenerator = new MockBridgeNumberGenerator(0);
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        playerMap = new PlayerMap(size);
        bridge = bridgeMaker.makeBridge(size);
    }

    @DisplayName("현재 다리에서 입력받은 이동 칸으로 이동할 수 있는지 여부를 가져온다.")
    @ParameterizedTest()
    @ValueSource(strings = {"D", "U"})
    void canMoveTest(String move) {
        boolean expected = true;
        if (move.equals("U")) {
            expected = false;
        }

        boolean canMove = bridgeGame.canMove(move, bridge);

        assertEquals(expected, canMove);
    }

    @DisplayName("사용자가 입력한 값으로 이동하면 이동 가능 여부에 따라 해당 칸에 표시된다.")
    @ParameterizedTest()
    @ValueSource(strings = {"D", "U"})
    void moveTest(String move) {
        Direction direction = Direction.DOWN_DIRECTION;
        String expected = "O";
        if (move.equals("U")) {
            expected = "X";
            direction = Direction.UP_DIRECTION;
        }

        bridgeGame.move(move, bridge, playerMap);

        int position = bridgeGame.getPosition();
        String mark = playerMap.getMark(direction.getDirection(), position - 1);
        assertEquals(expected, mark);
    }

    @DisplayName("retryCommand 를 입력하면 그에 따른 재시작 여부를 가져온다.")
    @ParameterizedTest()
    @ValueSource(strings = {"R", "Q"})
    void retryCommandTest(String retryCommand) {
        boolean expected = !retryCommand.equals("Q");

        boolean isRetry = bridgeGame.retry(retryCommand);

        assertEquals(expected, isRetry);
    }

    @DisplayName("사용자가 입력한 값으로 이동하면 이동 가능 여부에 따라 해당 칸에 표시된다.")
    @Test
    void decrementPositionTest() {
        String move = "U";
        bridgeGame.move(move, bridge, playerMap);

        int expected = bridgeGame.getPosition();

        bridgeGame.resetPrev(playerMap);
        int position = bridgeGame.getPosition();

        assertEquals(expected, position + 1);
    }

    @DisplayName("현재 위치 값을 가져온다.")
    @Test
    void getPositionTest() {
        int expected = 0;
        int position = bridgeGame.getPosition();

        assertEquals(expected, position);
    }
}
