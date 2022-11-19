package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("D", "D", "D"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("이동이 가능하면 ture, 이동이 불가능하면 false 확인")
    @CsvSource(value = {"D, true", "U, false"})
    @ParameterizedTest
    void move(String moving, boolean expected) {
        Boolean actual = bridgeGame.move(0, moving);
        assertThat(actual).isEqualTo(expected);
    }
}
