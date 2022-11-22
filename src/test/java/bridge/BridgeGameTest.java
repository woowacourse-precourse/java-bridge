package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    static final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("move 조건 맞을때 테스트")
    @Test
    void moveTest() {
        List<String> bridgeMap = new ArrayList<>();
        bridgeMap.add("U");
        assertThat(bridgeGame.move(bridgeMap, 0, "U")).isEqualTo(1);
    }

    @DisplayName("retry 조건 맞을때 테스트")
    @Test
    void retryTest() {
        assertThat(bridgeGame.retry("R")).isEqualTo(1);
    }


}
