package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import bridge.model.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }
    @Test
    public void 다리통과성공() {
        String result = bridgeGame.resultOfPhrase(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U"));
        assertThat(result).isEqualTo("[ O | O | O ]" + System.lineSeparator() + "[   |   |   ]");
    }
    @Test
    public void 다리통과실패() {
        String result = bridgeGame.resultOfPhrase(Arrays.asList("U", "D"), Arrays.asList("U", "U", "U"));
        assertThat(result).isEqualTo("[ O |   ]" + System.lineSeparator() + "[   | X ]");
    }
}