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
        BridgeGame testBridgeGame = new BridgeGame(new BridgeMaker(numberGenerator));
        testBridgeGame.initializeBridgeGame(3);
        assertThat(testBridgeGame.move("U")).isTrue();
        assertThat(testBridgeGame.getStepNumber()).isEqualTo(1);
    }

    @Test
    void stepCheckTest_2() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame testBridgeGame = new BridgeGame(new BridgeMaker(numberGenerator));
        testBridgeGame.initializeBridgeGame(3);
        testBridgeGame.move("U");
        assertThat(testBridgeGame.move("U")).isFalse();
        assertThat(testBridgeGame.getStepNumber()).isEqualTo(1);
    }
}