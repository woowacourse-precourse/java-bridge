package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void stepCheckTest_1() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame testBridgeGame = new BridgeGame(3, new BridgeMaker(numberGenerator));
        testBridgeGame.initializeBridgeGame();
        assertThat(testBridgeGame.stepCheck("U")).isTrue();
        assertThat(testBridgeGame.getStepNumber()).isEqualTo(1);
    }

    @Test
    void stepCheckTest_2() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame testBridgeGame = new BridgeGame(3, new BridgeMaker(numberGenerator));
        testBridgeGame.initializeBridgeGame();
        testBridgeGame.stepCheck("U");
        assertThat(testBridgeGame.stepCheck("U")).isFalse();
        assertThat(testBridgeGame.getStepNumber()).isEqualTo(1);
    }
}