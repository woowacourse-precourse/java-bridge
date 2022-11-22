package bridge.bridgeGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {
    @ParameterizedTest
    @CsvSource(value = {"U,U,true", "D,D,true", "U,D,false", "D,U,false"})
    public void moveTest(String bridge, String command, boolean result) {
        BridgeGame game = new BridgeGame(new ArrayList<>(List.of(bridge)));
        game.move(command);
        assertThat(game.getBridges().isEmpty()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"U,Q,false", "D,R,true"})
    public void retryTest(String bridge, String command, boolean result) {
        BridgeGame game = new BridgeGame(new ArrayList<>(List.of(bridge)));
        game.retry(command, () -> command);
        assertThat(game.isGameNotEnd()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"U,U,true", "D,D,true", "U,D,false", "D,U,false"})
    public void isMoveTest(String bridge, String command, boolean result) {
        BridgeGame game = new BridgeGame(new ArrayList<>(List.of(bridge)));
        assertThat(game.isMove(command)).isEqualTo(result);
    }

}