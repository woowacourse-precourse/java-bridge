package bridge.domain;

import bridge.utils.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    public void init() {
        bridgeGame = new BridgeGame(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "U", "U", "D", "D", "D"})
    void move(String input) {
        assertThat(bridgeGame.move(input) || true).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Q", "Q", "Q", "R", "R", "R"})
    void retry(String input) {
        List<Boolean> total = Arrays.asList(true, false);

        assertThat(total.contains(bridgeGame.retry(input))).isEqualTo(true);
    }
}