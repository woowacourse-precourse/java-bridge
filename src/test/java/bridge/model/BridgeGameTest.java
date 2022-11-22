package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @ParameterizedTest
    @CsvSource(value = {"U,U,true", "D,D,true", "U,D,false", "D,U,false"})
    void moveBridge(String correctStep, String moving, boolean expected) {
        boolean result = bridgeGame.move(correctStep, moving);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"R,true", "Q,false"})
    void choiceGameCommand(String gameCommand, boolean expected) {
        boolean result = bridgeGame.retry(gameCommand);
        assertThat(result).isEqualTo(expected);
    }
}