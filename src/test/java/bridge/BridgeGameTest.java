package bridge;

import enumCollections.AvailableInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    private final int DEFAULT_BRIDGE_SIZE = 10;
    private final int INITIALIZED_TRIAL = 1;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
        bridgeGame.generateBridge(DEFAULT_BRIDGE_SIZE);
    }

    @ParameterizedTest
    @CsvSource(value = {"U:D"}, delimiter = ':')
    @DisplayName("사용자 이동 테스트")
    void 사용자_이동_테스트(String UP, String DOWN) {
        bridgeGame.move(UP);
        bridgeGame.move(DOWN);
        assertThat(bridgeGame.getMap())
                .toString()
                .matches("OX");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    @DisplayName("사용자 재시도 테스트")
    void 사용자_재시도_테스트(int trials) {
        for (int trial = 0; trial < trials; trial++) {
            bridgeGame.retry(AvailableInput.RETRY_COMMAND.getUserInput());
        }
        assertThat(bridgeGame.getTrial())
                .isEqualTo(Integer.toString(trials + INITIALIZED_TRIAL));
    }
}
