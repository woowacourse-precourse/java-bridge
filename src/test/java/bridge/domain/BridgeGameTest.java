package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("이동이 가능하면 O, 불가능하면 X로 표시한다.")
    @CsvSource(value = {"D, O", "U, X"})
    @ParameterizedTest
    void move(String moving, String expected) {
        Bridge bridge = new Bridge(List.of("D", "U", "U"));
        String actual = bridgeGame.move(bridge, 0, moving);
        assertThat(actual).isEqualTo(expected);
    }
}
