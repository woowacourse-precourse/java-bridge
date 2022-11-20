package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void setupBridgeGame() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        // bridge => "UDD"
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame.setBridge(bridge);
    }


    @DisplayName("Q를 입력하면 false, R을 입력하면 true를 리턴한다.")
    @Test
    void retryTest_1() {
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }


    @DisplayName("Q를 입력하면 false, R을 입력하면 true를 리턴한다.")
    @Test
    void retryTest_2() {
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }
}
