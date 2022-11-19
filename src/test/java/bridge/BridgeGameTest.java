package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeGame;
import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame(new BridgeGameResult());

    @DisplayName("이동이 가능하면 ture, 이동이 불가능하면 false 확인")
    @CsvSource(value = {"D, true", "U, false"})
    @ParameterizedTest
    void move(String moving, boolean expected) {
        Bridge bridge = new Bridge(List.of("D", "U", "U"));
        Boolean actual = bridgeGame.move(bridge, 0, moving);
        assertThat(actual).isEqualTo(expected);
    }
}
