package bridge;

import bridge.validation.Validation;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static bridge.utils.constant.Constant.FAILED;
import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {

    List<String> bridge = new ArrayList<>();
    Controller controller = new Controller(new InputView(new Validation()),
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
    @DisplayName("Q를 누르면 성공 실패 상관없이 Q 배출")
    void quit() {
        String q = "Q";
        InputStream i = new ByteArrayInputStream(q.getBytes());
        System.setIn(i);
        String quit = controller.askQuit("실패");
        assertThat(quit).isEqualTo("Q");
    }

    @Test
    @DisplayName("건넌 위치가 다리사이즈만큼 혹은 떨어질 때까지 잘 만들어지는지 테스트")
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
    @DisplayName("다리 성공 실패 잘 판단하는지 테스트")
    void SuccessCrossingBridgeTest() {
        String input = "U" + "\n" + "D" + "\n" + "U";
        InputStream i = new ByteArrayInputStream(input.getBytes());

        System.setIn(i);

        String result = controller.successCrossingBridge(bridge);

        assertThat(result).isEqualTo(FAILED.getValue());
    }

    @Test
    @DisplayName("통합 테스트")
    void whileQuitIsRTest() {
        String input = "U" + "\n" + "D" + "\n" + "U" + "\n" + "R" +"\n"+ "U" + "\n" + "D" + "\n" + "D";
        InputStream i = new ByteArrayInputStream(input.getBytes());

        System.setIn(i);
        String quit = controller.whileQuitIsR(bridge);
        assertThat("Q").isEqualTo(quit);
    }
}
