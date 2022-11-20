package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void 객체_생성() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void 칸을_이동하는_메서드_테스트() {

        assertThat(bridgeGame.move(4, "U", Arrays.asList("U", "D", "U"))).isFalse();

        assertThat(bridgeGame.move(2, "U", Arrays.asList("U", "D", "U"))).isTrue();
    }

    @Test
    void 재시작_메서드_테스트() {
        assertThat(bridgeGame.retry("R")).isTrue();
    }
}