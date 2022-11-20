package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
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
        PlayerMap playerMap;
        BridgeMap bridgeMap = new BridgeMap(List.of(bridgeValue));
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        playerMap = bridgeGame.move(new Moving(playerValue));
        List<List> estimatedResult = List.of(List.of(firstResult), List.of(secondResult));
        assertThat(playerMap.getPlayerMap()).isEqualTo(estimatedResult);
    }

    @Test
    public void retry_R_0() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMap(List.of("U", "U", "U")));
        PlayerMap playerMap = bridgeGame.move(new Moving("U"));
        playerMap = bridgeGame.move(new Moving("D"));
        playerMap = bridgeGame.retry(new GameCommand("R"));
        assertThat(playerMap.getSize()).isEqualTo(0);
    }

    @Test
    public void retry_Q_Test() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMap(List.of("U", "U", "U")));
        PlayerMap playerMap = bridgeGame.move(new Moving("U"));
        playerMap = bridgeGame.move(new Moving("D"));
        playerMap = bridgeGame.retry(new GameCommand("Q"));
        List<List> estimatedResult = List.of(List.of("O", " "), List.of(" ", "X"));
        assertThat(playerMap.getPlayerMap()).isEqualTo(estimatedResult);
    }

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\"")
    @CsvSource(value = {"U, U, true", "U, D, true"})
    public void isEnd_test(String bridgeValue, String playerValue, boolean value) {
        BridgeMap bridgeMap = new BridgeMap(List.of(bridgeValue));
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        bridgeGame.move(new Moving(playerValue));
        assertThat(bridgeGame.isEnd()).isEqualTo(value);
    }

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\"")
    @CsvSource(value = {"U, U, true", "U, D, false"})
    public void isMove_test(String bridgeValue, String playerValue, boolean value) {
        BridgeMap bridgeMap = new BridgeMap(List.of(bridgeValue));
        BridgeGame bridgeGame = new BridgeGame(bridgeMap);
        bridgeGame.move(new Moving(playerValue));
        assertThat(bridgeGame.isMove()).isEqualTo(value);
    }
}