package bridge.view;

import bridge.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private static OutputView outputView;
    private static OutputStream consoleOut;


    @BeforeEach
    void init() {
        outputView = new OutputView();
        consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut));

    }

    @Test
    void 맵_그리기_테스트1() {
        List<String> realBridges = List.of("U", "D", "U", "D");
        List<String> selectBridges = List.of("U", "D", "D");

        outputView.printMap(realBridges, selectBridges);
        String printOut = consoleOut.toString().trim();

        assertThat(printOut).contains(
                "[ O |   |   ]",
                "[   | O | X ]"
        );
    }

    @Test
    void 맵_그리기_테스트2() {
        List<String> realBridges = List.of("U", "D", "D", "D");
        List<String> selectBridges = List.of("U", "D", "D");

        outputView.printMap(realBridges, selectBridges);
        String printOut = consoleOut.toString().trim();

        assertThat(printOut).contains(
                "[ O |   |   ]",
                "[   | O | O ]"
        );
    }

    @Test
    void 맵_그리기_테스트3() {
        List<String> realBridges = List.of("U", "D", "D", "D", "U");
        List<String> selectBridges = List.of("U", "D", "D", "U");

        outputView.printMap(realBridges, selectBridges);
        String printOut = consoleOut.toString().trim();

        assertThat(printOut).contains(
                "[ O |   |   | X ]",
                "[   | O | O |   ]"
        );
    }
}
