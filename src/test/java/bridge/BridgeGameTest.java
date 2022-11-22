package bridge;


import bridge.domain.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(Arrays.asList(new String[]{"U", "U", "D"}));
    }

    @Test
    void moveTest() {
        bridgeGame.setUser_bridge(Arrays.asList(new String[]{"U", "D", "U"}));
        assertThat(bridgeGame.getUser_bridge()).containsExactly("U", "D", "U");
    }

    @Test
    void retryTest() {
        bridgeGame.retry();
        assertThat(bridgeGame.getUser_bridge().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({"U,U,D,true", "D,D,D,true", "U,D,D,true"})
    void isEndTest1(String w1, String w2, String w3, boolean output) {
        bridgeGame.setUser_bridge(Arrays.asList(new String[]{w1, w2, w3}));
        assertThat(bridgeGame.isEnd()).isEqualTo(output);
    }

    @Test
    void isEndTest2() {
        bridgeGame.setUser_bridge(Arrays.asList(new String[]{"U"}));
        assertThat(bridgeGame.isEnd()).isEqualTo(false);
    }

    @Test
    void isSuccessTest1() {
        bridgeGame.setUser_bridge(Arrays.asList(new String[]{"U", "D", "U"}));
        assertThat(bridgeGame.isSuccess()).isEqualTo(false);
    }

    @Test
    void isSuccessTest2() {

        bridgeGame.setUser_bridge(Arrays.asList(new String[]{"U", "U", "D"}));
        assertThat(bridgeGame.isSuccess()).isEqualTo(true);
    }

}
