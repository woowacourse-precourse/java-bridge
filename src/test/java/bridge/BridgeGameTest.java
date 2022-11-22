package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    BridgeGame bridgeGame;
    List<String> bridge;

    @BeforeEach
    void beforeEach() {
        bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("사용자의 입력값과 다음 칸의 값이 같으면 true를 반환하고, 다르면 false를 반환한다.")
    @CsvSource(value = {"U:true:D:true:U:true", "D:false:U:false:D:false"}, delimiter = ':')
    @ParameterizedTest
    void movingResultTest(String moving1, boolean result1,
            String moving2, boolean result2,
            String moving3, boolean result3) {
        // round 1
        Assertions.assertThat(bridgeGame.move(moving1)).isEqualTo(result1);
        // round 2
        Assertions.assertThat(bridgeGame.move(moving2)).isEqualTo(result2);
        // round 3
        Assertions.assertThat(bridgeGame.move(moving3)).isEqualTo(result3);
    }
}