package bridge.ui;

import bridge.domain.BridgeShapeMatcher;
import bridge.domain.Player;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class OutputViewTest {

    private final List<BridgeShapeMatcher> bridgeShapeMatchers = new ArrayList<>();
    private OutputView outputView;
    private Player player;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(output));
        outputView = new OutputView();
        bridgeShapeMatchers.add(BridgeShapeMatcher.DOWN_TRUE);
        bridgeShapeMatchers.add(BridgeShapeMatcher.UP_TRUE);
        bridgeShapeMatchers.add(BridgeShapeMatcher.DOWN_TRUE);
        bridgeShapeMatchers.add(BridgeShapeMatcher.DOWN_FALSE);
        player = new Player(bridgeShapeMatchers);
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void printMap() {
        outputView.printMap(player);
        assertThat(output.toString()).contains(
                "[   | O |   |   ]",
                "[ O |   | O | X ]"
        );
    }

    @Test
    void printResult() {
        outputView.printResult(player);
        assertThat(output.toString()).contains(
                "최종 게임 결과",
                "[   | O |   |   ]",
                "[ O |   | O | X ]",
                "게임 성공 여부: ",
                "총 시도한 횟수: "
        );
    }
}