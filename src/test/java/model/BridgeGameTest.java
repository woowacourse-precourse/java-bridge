package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    public void 다리통과() {
        BridgeGame bridgeGame = new BridgeGame();
        String result = bridgeGame.resultOfPhrase(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U"));
        assertThat(result).isEqualTo("[ O | O | O ]" + System.lineSeparator() + "[   |   |   ]");
    }
}