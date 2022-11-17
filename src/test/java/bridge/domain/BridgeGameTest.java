package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    List<String> bridge = new ArrayList<>(List.of("U","D","U"));
    BridgeGame bridgeGame = new BridgeGame();

    @ParameterizedTest
    @ValueSource(strings = {"U"})
     void 사용자_이동(String moveInput) {
        assertThat(bridgeGame.move(moveInput,bridge,0)).isTrue();
        assertThat(bridgeGame.move(moveInput,bridge,1)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"R"})
    void 다시_도전(String restartInput) {
        assertThat(bridgeGame.retry(restartInput)).isTrue();
    }
}