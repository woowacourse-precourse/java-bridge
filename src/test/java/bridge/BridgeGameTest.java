package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private Bridge bridge;
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridge = new Bridge(Arrays.asList("U", "U", "U"), 3);
        bridgeGame = new BridgeGame(bridge);
    }

    @Test
    public void 이동가능_여부_테스트() {
        assertThat(bridgeGame.isMovable("U")).isTrue();
        assertThat(bridgeGame.isMovable("D")).isFalse();
    }

    @Test
    public void 이동가능_O반환_테스트() {
        assertThat(bridgeGame.markMovable("U")).isEqualTo("O");
    }

    @Test
    public void 이동불가능_X반환_테스트() {
        assertThat(bridgeGame.markMovable("D")).isEqualTo("X");
    }
}
