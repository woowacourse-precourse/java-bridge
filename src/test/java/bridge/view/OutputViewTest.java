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

    @DisplayName("게임을 첫 번째에 성공시 printResult() 로 정확한 내용을 출력한다.")
    @Test
    void printResultTest1() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        OutputView outputView = new OutputView(bridgeGame);
        outputView.printResult();
        assertEquals("최종 게임 결과\n[ O |   | O |   ]\n[   | O |   | O ]\n\n게임 성공 여부: 성공\n총 시도한 횟수: 1",
                outputStreamCaptor.toString()
                        .trim());
    }

    @DisplayName("게임 첫 번째 실패시 printResult() 로 정확한 내용을 출력한다.")
    @Test
    void printResultTest2() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        OutputView outputView = new OutputView(bridgeGame);
        outputView.printResult();
        assertEquals("최종 게임 결과\n[ O |   |   ]\n[   | O | X ]\n\n게임 성공 여부: 실패\n총 시도한 횟수: 1",
                outputStreamCaptor.toString()
                        .trim());
    }

    @DisplayName("게임을 두 번째에 성공시 printResult() 로 정확한 내용을 출력한다.")
    @Test
    void printResultTest3() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView(bridgeGame);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        outputView.printResult();
        assertEquals("최종 게임 결과\n[ O |   | O |   ]\n[   | O |   | O ]\n\n게임 성공 여부: 성공\n총 시도한 횟수: 2",
                outputStreamCaptor.toString()
                        .trim());
    }

    @DisplayName("게임 두 번째 실패시 정확한 printResult() 로 내용을 출력한다.")
    @Test
    void printResultTest4() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView outputView = new OutputView(bridgeGame);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.retry();
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");
        outputView.printResult();
        assertEquals("최종 게임 결과\n[ O |   | O | X ]\n[   | O |   |   ]\n\n게임 성공 여부: 실패\n총 시도한 횟수: 2",
                outputStreamCaptor.toString()
                        .trim());
    }
}