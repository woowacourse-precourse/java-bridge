package bridge.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.domain.BridgeGame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("입력 값에 따른 다리를 출력한다.")
    @Test
    void printMapTest1() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");
        OutputView outputView = new OutputView(bridgeGame);
        outputView.printMap();
        assertEquals("[ O |   | O | X ]\n[   | O |   |   ]",
                outputStreamCaptor.toString()
                        .trim());
    }

    @DisplayName("입력 값에 따른 다리를 출력한다.")
    @Test
    void printMapTest2() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        OutputView outputView = new OutputView(bridgeGame);
        outputView.printMap();
        assertEquals("[ O |   |   ]\n[   | O | X ]",
                outputStreamCaptor.toString()
                        .trim());
    }
}