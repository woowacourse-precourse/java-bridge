package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

class BridgeGameTest {
    private static final List<String> BRIDGE = Arrays.asList("D", "U", "D", "D");

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @ParameterizedTest
    @CsvSource({"D,0,' O '", "U,3,' X '"})
    void move_test(String moving, int bridgeIndex, String resultSymbol) {
        assertThat(bridgeGame.move(BRIDGE, moving, bridgeIndex))
                .isEqualTo(resultSymbol);
    }
}