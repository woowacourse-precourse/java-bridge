package bridge.view.util;

import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMapDrawerTest {
    private static OutputStream consoleOut;


    @BeforeEach
    void init() {
        consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut));
    }


    @Test
    void 맵_그리기_테스트1() {
        Result failResult = Result.fail(new Bridge(List.of("U", "D", "D")));

        String map = BridgeMapDrawer.draw(failResult);
        System.out.println(map);

        String printOut = consoleOut.toString().trim();

        assertThat(printOut).contains(
                "[ O |   |   ]",
                "[   | O | X ]"
        );
    }

    @Test
    void 맵_그리기_테스트2() {
        Result successResult = Result.success(new Bridge(List.of("U", "D", "D")));

        String map = BridgeMapDrawer.draw(successResult);
        System.out.println(map);

        String printOut = consoleOut.toString().trim();


        assertThat(printOut).contains(
                "[ O |   |   ]",
                "[   | O | O ]"
        );
    }
    @Test
    void 맵_그리기_테스트3() {
        Result successResult = Result.success(new Bridge(List.of("U", "D", "D", "U")));

        String map = BridgeMapDrawer.draw(successResult);
        System.out.println(map);

        String printOut = consoleOut.toString().trim();


        assertThat(printOut).contains(
                "[ O |   |   | O ]",
                "[   | O | O |   ]"
        );
    }

    @Test
    void 맵_그리기_테스트4() {
        Result successResult = Result.fail(new Bridge(List.of("U", "D", "D", "U")));

        String map = BridgeMapDrawer.draw(successResult);
        System.out.println(map);

        String printOut = consoleOut.toString().trim();


        assertThat(printOut).contains(
                "[ O |   |   | X ]",
                "[   | O | O |   ]"
        );
    }

}