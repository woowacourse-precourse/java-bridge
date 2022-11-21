package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

class BridgeGameTest {
    private Bridge bridge;
    private BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void setUp() {
        List<String> bridgeContent = List.of("U","D","U","D");
        bridge = new Bridge(bridgeContent);
    }

    @AfterEach
    void tearDown() {
        bridge = null;
    }

    @DisplayName("move메소드 올바른 경우 테스트.")
    @ParameterizedTest
    @CsvSource({
            "U, 0",
            "D, 1",
            "U, 2",
            "D, 3"
    })
    void move_right(String userChoice, int index) {
        boolean bool = bridgeGame.move(bridge, userChoice, index);
        Assertions.assertThat(bool).isEqualTo(true);
    }

    @DisplayName("move메소드 잘못된 경우 테스트.")
    @ParameterizedTest
    @CsvSource({
            "D, 0",
            "U, 1",
            "D, 2",
            "U, 3"
    })
    void move_false(String userChoice, int index) {
        boolean bool = bridgeGame.move(bridge, userChoice, index);
        Assertions.assertThat(bool).isEqualTo(false);
    }

    @DisplayName("retry메소드 그만두는 경우 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"Q","q"})
    void retry_false(String userChoice) {
        boolean retry = bridgeGame.retry(userChoice);
        Assertions.assertThat(retry).isEqualTo(false);
    }

    @DisplayName("retry메소드 재시도하는 경우 테스트.")
    @ParameterizedTest
    @ValueSource(strings = {"R","r"})
    void retry_true(String userChoice) {
        boolean retry = bridgeGame.retry(userChoice);
        Assertions.assertThat(retry).isEqualTo(true);
    }
}