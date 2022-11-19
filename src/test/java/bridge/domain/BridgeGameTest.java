package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.GameMoving;
import bridge.domain.vo.PlayerMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\" \"{3}\"")
    @CsvSource(value = {"U, U, O,' '", "U, D,' ',X", "D, U,X,' '", "D, D,' ',O"})
    public void move_test(String bridgeValue, String playerValue, String firstResult,
            String secondResult) {
        PlayerMap playerMap = new PlayerMap();
        BridgeMap bridgeMap = new BridgeMap(List.of(bridgeValue));
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        playerMap = bridgeGame.move(new GameMoving(playerValue).toString(), playerMap);
        List<List> estimatedResult = List.of(List.of(firstResult), List.of(secondResult));
        assertThat(playerMap.getPlayerMap()).isEqualTo(estimatedResult);
    }

    @Test
    public void retry_R_0() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMap(List.of("U", "U", "U")));
        PlayerMap playerMap = new PlayerMap();
        playerMap = bridgeGame.move(new GameMoving("U").toString(), playerMap);
        playerMap = bridgeGame.move(new GameMoving("D").toString(), playerMap);
        playerMap = bridgeGame.retry("R", playerMap);
        assertThat(playerMap.getSize()).isEqualTo(0);
    }

    @Test
    public void retry_Q_Test() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMap(List.of("U", "U", "U")));
        PlayerMap playerMap = new PlayerMap();
        playerMap = bridgeGame.move(new GameMoving("U").toString(), playerMap);
        playerMap = bridgeGame.move(new GameMoving("D").toString(), playerMap);
        playerMap = bridgeGame.retry("Q", playerMap);
        List<List> estimatedResult = List.of(List.of("O", " "), List.of(" ", "X"));
        assertThat(playerMap.getPlayerMap()).isEqualTo(estimatedResult);
    }
}