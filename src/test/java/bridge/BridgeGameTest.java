package bridge;

import static bridge.constant.MoveResult.CAN_MOVE;
import static bridge.constant.MoveResult.CAN_NOT_MOVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.constant.GameStatus;
import bridge.constant.MoveResult;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    @ParameterizedTest
    @ValueSource(ints = {0})
    void moveByU(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "U";
        BridgeGame bridgeGame = new BridgeGame();

        // when
        MoveResult result = bridgeGame.move(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_MOVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void moveByD(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "D";
        BridgeGame bridgeGame = new BridgeGame();

        // when
        MoveResult result = bridgeGame.move(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_MOVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void moveByNotMove(int count) {
        // given
        List<String> bridge = List.of("U", "D", "D");
        String player = "D";
        BridgeGame bridgeGame = new BridgeGame();

        // when
        MoveResult result = bridgeGame.move(bridge, player, count);

        // then
        assertThat(result).isEqualTo(CAN_NOT_MOVE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void retry(int round) {
        // given
        BridgeGame bridgeGame = new BridgeGame();
        int countOfGame = bridgeGame.getBridgeGameStat().getCountOfGame();

        // when
        bridgeGame.retry();

        // then
        assertThat(bridgeGame.getCountOfRound()).isEqualTo(round);
        assertThat(bridgeGame.getBridgeGameStat().getBridgeMaps()).isEmpty();
        assertThat(bridgeGame.getBridgeGameStat().getGameStatus()).isEqualTo(GameStatus.FAIL);
        assertThat(bridgeGame.getBridgeGameStat().getCountOfGame()).isEqualTo(countOfGame + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MAX_VALUE})
    void quit(int round) {
        // given
        BridgeGame bridgeGame = new BridgeGame();

        // when
        bridgeGame.quit();

        // then
        assertThat(bridgeGame.getCountOfRound()).isEqualTo(round);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void isCountOfRoundLessThan(int bridgeSize) {
        // given
        BridgeGame bridgeGame = new BridgeGame();

        // when
        boolean result = bridgeGame.isCountOfRoundLessThan(bridgeSize);

        // then
        assertTrue(result);
    }

    @Test
    void nextRound() {
        // given
        BridgeGame bridgeGame = new BridgeGame();
        int countOfRound = bridgeGame.getCountOfRound();

        // when
        bridgeGame.nextRound();

        // then
        assertThat(bridgeGame.getCountOfRound()).isEqualTo(countOfRound + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void checkGameWinByNotWIng(int bridgeSize) {
        // given
        BridgeGame bridgeGame = new BridgeGame();

        // when
        bridgeGame.checkGameWin(bridgeSize);

        // then
        assertThat(bridgeGame.getBridgeGameStat().getGameStatus()).isEqualTo(GameStatus.FAIL);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    void checkGameWin(int bridgeSize) {
        // given
        BridgeGame bridgeGame = new BridgeGame();

        // when
        bridgeGame.nextRound();
        bridgeGame.nextRound();
        bridgeGame.checkGameWin(bridgeSize);

        // then
        assertThat(bridgeGame.getBridgeGameStat().getGameStatus()).isEqualTo(GameStatus.SUCCESS);
    }
}