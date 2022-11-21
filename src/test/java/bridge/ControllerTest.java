package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static bridge.utils.constant.Constant.FAILED;
import static bridge.utils.constant.Constant.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {

    List<String> bridge = new ArrayList<>();
    Controller controller = new Controller(new InputView(),
            new BridgeGame(),
            new BridgeMaker(new BridgeRandomNumberGenerator()),
            new OutputView());
    @BeforeEach
    void setBridge() {
        bridge.add("U");
        bridge.add("D");
        bridge.add("D");
    }

    @Test
    void quit() {
        String q = "Q";
        InputStream i = new ByteArrayInputStream(q.getBytes());
        System.setIn(i);
        String quit = controller.askQuit("실패");
        assertThat(quit).isEqualTo("Q");
    }

    @Test
    void endOfTheGameTest() {
        List<List<String>> bridges = new ArrayList<>();
        List<String> bridgeUp = List.of("O"," "," ");
        List<String> bridgeDown = List.of(" ", "O", "X");

        bridges.add(bridgeUp);
        bridges.add(bridgeDown);

        String result = controller.endOfTheGame(bridges);
        assertThat(FAILED.getValue()).isEqualTo(result);
    }

    @Test
    void SuccessCrossingBridgeTest() {
        String input = "U" + "\n" + "D" + "\n" + "U";
        InputStream i = new ByteArrayInputStream(input.getBytes());

        System.setIn(i);

        String result = controller.successCrossingBridge(bridge);

        assertThat(result).isEqualTo(FAILED.getValue());
    }

    @Test
    void whileQuitIsRTest() {
        String input = "U" + "\n" + "D" + "\n" + "U" + "\n" + "R" +"\n"+ "U" + "\n" + "D" + "\n" + "D";
        InputStream i = new ByteArrayInputStream(input.getBytes());

        System.setIn(i);
        String quit = controller.whileQuitIsR(bridge);
        assertThat("Q").isEqualTo(quit);
    }
}
