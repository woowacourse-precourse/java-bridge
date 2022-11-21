package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\" \"{3}\"")
    @CsvSource(value = {"U, U, O,' '", "U, D,' ',X", "D, U,X,' '", "D, D,' ',O"})
    public void move_test(String bridgeValue, String playerValue, String firstResult,
            String secondResult) {
        BridgeMap bridgeMap = new BridgeMap(List.of(bridgeValue));
        BridgeGame bridgeGame = BridgeGame.from(bridgeMap);
        bridgeGame.move(Moving.from(playerValue));
        List<List> estimatedResult = List.of(List.of(firstResult), List.of(secondResult));
        assertThat(bridgeGame.getPlayerMap()).isEqualTo(estimatedResult);
    }

    @Test
    public void retry_R_0() {
        BridgeGame bridgeGame = BridgeGame.from(new BridgeMap(List.of("U", "U", "U")));
        bridgeGame.move(Moving.from("U"));
        bridgeGame.move(Moving.from("D"));
        bridgeGame.retry(new GameCommand("R"));
        assertThat(bridgeGame.getCount()).isEqualTo(2);
    }

    @Test
    public void retry_Q_Test() {
        BridgeGame bridgeGame = BridgeGame.from(new BridgeMap(List.of("U", "U", "U")));
        bridgeGame.move(Moving.from("U"));
        bridgeGame.move(Moving.from("D"));
        bridgeGame.retry(new GameCommand("Q"));
        List<List> estimatedResult = List.of(List.of("O", " "), List.of(" ", "X"));
        assertThat(bridgeGame.getPlayerMap()).isEqualTo(estimatedResult);
    }

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\"")
    @CsvSource(value = {"U, U, true", "U, D, true"})
    public void isEnd_test(String bridgeValue, String playerValue, boolean value) {
        BridgeMap bridgeMap = new BridgeMap(List.of(bridgeValue));
        BridgeGame bridgeGame = BridgeGame.from(bridgeMap);
        bridgeGame.move(Moving.from(playerValue));
        assertThat(bridgeGame.isEnd()).isEqualTo(value);
    }

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\"")
    @CsvSource(value = {"U, U, true", "U, D, false"})
    public void isMove_test(String bridgeValue, String playerValue, boolean value) {
        BridgeMap bridgeMap = new BridgeMap(List.of(bridgeValue));
        BridgeGame bridgeGame = BridgeGame.from(bridgeMap);
        assertThat(bridgeGame.move(Moving.from(playerValue))).isEqualTo(value);
    }
}