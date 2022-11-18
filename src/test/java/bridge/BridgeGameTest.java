package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static List<String> bridge = new ArrayList<>(List.of());
    private static BridgeGame bridgeGame = new BridgeGame();

    @BeforeAll
    public static void setBridge() {
        bridge.add("U");
        bridge.add("D");
    }

    @DisplayName("설정된 다리에 따라 이동 방향에 따른 결과를 반환한다.")
    @Test
    void moveBridge() {
        assertThat(bridgeGame.move(bridge, "U")).isEqualTo("O");
        assertThat(bridgeGame.move(bridge, "U")).isEqualTo("X");
    }
}
