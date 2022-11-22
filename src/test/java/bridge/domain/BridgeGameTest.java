package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    @BeforeEach
    void setUp() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame(3, bridgeMaker);
    }

    @Test
    void 다리_이동_테스트() {
        List<String> userInput = bridgeGame.move("U");
        assertThat(userInput).isEqualTo(Arrays.asList("U"));

        List<String> userSecondInput = bridgeGame.move("D");
        assertThat(userSecondInput).isEqualTo(Arrays.asList("U", "D"));
    }

    @Test
    void 다리_게임_재시작_테스트() {
        int beforeTryCount = bridgeGame.getTryCount();
        bridgeGame.retry();
        assertThat(bridgeGame.getUserInput().size()).isEqualTo(0);
        assertThat(bridgeGame.getTryCount()).isEqualTo(beforeTryCount + 1);
    }
}