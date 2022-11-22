package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void can_move_test1() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.bridge = Arrays.asList("U", "D", "D");
        bridgeGame.userLocation = 0;
        boolean result = bridgeGame.canMove("U");
        Assertions.assertEquals(true, result);
    }

    @Test
    void can_move_test2() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.bridge = Arrays.asList("U", "D", "D");
        bridgeGame.userLocation = 1;
        boolean result = bridgeGame.canMove("U");
        Assertions.assertEquals(false, result);
    }

    @Test
    void can_move_test3() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.bridge = Arrays.asList("U", "U", "U");
        bridgeGame.userLocation = 2;
        boolean result = bridgeGame.canMove("D");
        Assertions.assertEquals(false, result);
    }

    @Test
    void move_test() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.bridge = Arrays.asList("U", "U", "U");
        bridgeGame.userInput = Arrays.asList("U", "U");
        bridgeGame.userLocation = 1;
        bridgeGame.move("U");
        Assertions.assertEquals("[ O | O ]\n[   |   ]\n\n", outputMessage.toString());
    }
}