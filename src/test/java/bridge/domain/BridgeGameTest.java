package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.Moving;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\" \"{3}\"")
    @CsvSource(value = {"U, U, O,' '", "U, D,' ',X", "D, U,X,' '", "D, D,' ',O"})
    public void move_test(String bridgeValue, String playerValue, String firstResult,
            String secondResult) {
        BridgeMap bridgeMap = BridgeMap.from(List.of(bridgeValue));
        BridgeGame bridgeGame = BridgeGame.from(bridgeMap);
        bridgeGame.move(Moving.from(playerValue));
        List<List> estimatedResult = List.of(List.of(firstResult), List.of(secondResult));
        assertThat(bridgeGame.getPlayerMap()).isEqualTo(estimatedResult);
    }

    @ParameterizedTest(name = "[{index}] input {1} ")
    @CsvSource(value =
            {
                    "U, U, D : R : 성공",
                    "U, U, D : Q : 실패"
            }
            , delimiter = ':')
    public void retry_Test(String move, String retry, String result) {
        List<String> moving = List.of(move.split(", "));

        BridgeGame bridgeGame = BridgeGame.from(BridgeMap.from(List.of("U", "U", "U")));
        moving.forEach(s -> bridgeGame.move(Moving.from(s)));

        bridgeGame.retry(GameCommand.from(retry));
        assertThat(bridgeGame.getStatus()).isEqualTo(result);
    }

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\"")
    @CsvSource(value = {"U, U, true", "U, D, true"})
    public void isEnd_test(String bridgeValue, String playerValue, boolean value) {
        BridgeMap bridgeMap = BridgeMap.from(List.of(bridgeValue));
        BridgeGame bridgeGame = BridgeGame.from(bridgeMap);
        bridgeGame.move(Moving.from(playerValue));
        assertThat(bridgeGame.isEnd()).isEqualTo(value);
    }

    @ParameterizedTest(name = "[{index}] input {0} {1} \"{2}\"")
    @CsvSource(value = {"U, U, true", "U, D, false"})
    public void isMove_test(String bridgeValue, String playerValue, boolean value) {
        BridgeMap bridgeMap = BridgeMap.from(List.of(bridgeValue));
        BridgeGame bridgeGame = BridgeGame.from(bridgeMap);
        assertThat(bridgeGame.move(Moving.from(playerValue))).isEqualTo(value);
    }
}