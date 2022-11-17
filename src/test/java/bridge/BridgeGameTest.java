package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("이동 결과를 확인하는 테스트")
    @ParameterizedTest
    @CsvSource({"U,U,O", "U,D,X", "D,D,O", "D,U,X"})
    void move(String direction, String bridge, String expected) {
        String actual = bridgeGame.move(direction, bridge);

        assertThat(actual).isEqualTo(expected);
    }

}