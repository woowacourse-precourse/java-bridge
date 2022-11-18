package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

//    @Test
//    void stepCheckTest_1() {
//        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
//        BridgeGame testBridgeGame = new BridgeGame(new BridgeMaker(numberGenerator));
//        testBridgeGame.initializeBridgeGame(3);
//        assertThat(testBridgeGame.move("U")).isTrue();
//        assertThat(testBridgeGame.getStepNumber()).isEqualTo(1);
//    }
//
//    @Test
//    void stepCheckTest_2() {
//        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
//        BridgeGame testBridgeGame = new BridgeGame(new BridgeMaker(numberGenerator));
//        testBridgeGame.initializeBridgeGame(3);
//        testBridgeGame.move("U");
//        assertThat(testBridgeGame.move("U")).isFalse();
//        assertThat(testBridgeGame.getStepNumber()).isEqualTo(1);
//    }

    @Test
    void retryTest_1() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame testBridgeGame = new BridgeGame(new BridgeMaker(numberGenerator));
        testBridgeGame.initializeBridgeGame(3);
        testBridgeGame.move("U");
        testBridgeGame.retry();
        assertThat(testBridgeGame.getTryNumber()).isEqualTo(1);
        assertThat(testBridgeGame.getStepNumber()).isEqualTo(0);
    }

    @Test
    void retryTest_2() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame testBridgeGame = new BridgeGame(new BridgeMaker(numberGenerator));
        testBridgeGame.initializeBridgeGame(3);
        testBridgeGame.move("U");
        testBridgeGame.move("D");
        testBridgeGame.retry();
        testBridgeGame.move("U");
        testBridgeGame.retry();
        assertThat(testBridgeGame.getTryNumber()).isEqualTo(2);
        assertThat(testBridgeGame.getStepNumber()).isEqualTo(0);
    }

    @Test
    void terminateCheckTest() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeGame testBridgeGame = new BridgeGame(new BridgeMaker(numberGenerator));
        testBridgeGame.initializeBridgeGame(3);
        testBridgeGame.move("U");
        testBridgeGame.move("D");
        testBridgeGame.move("D");
        assertThat(testBridgeGame.terminateCheck()).isTrue();
    }
}