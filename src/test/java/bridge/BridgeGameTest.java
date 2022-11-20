package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void 객체_생성() {
        bridgeGame = new BridgeGame();
    }

    @Test
    void 칸을_이동하는_메서드_테스트() {

        Assertions.assertThat(bridgeGame.move(4, "U", Arrays.asList("U", "D", "U"))).isFalse();

        Assertions.assertThat(bridgeGame.move(2, "U", Arrays.asList("U", "D", "U"))).isTrue();
    }
}