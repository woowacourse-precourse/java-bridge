package bridge.view;

import bridge.utill.TestBridgeGenerator;
import bridge.model.BridgeGame;
import bridge.utill.ConsoleTestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class OutputViewTest {
    ConsoleTestUtil consoleTestUtil = new ConsoleTestUtil();
    TestBridgeGenerator testBridgeGenerator = new TestBridgeGenerator();
    OutputView outputView = new OutputView();

    List<String> bridge = testBridgeGenerator.generate(List.of(0, 1, 0, 1, 0, 1));
    BridgeGame game = new BridgeGame(bridge);

    @Test
    @DisplayName("이동 결과 테스트")
    public void printMove(){
        game.move("U");
        game.move("D");
        game.move("U");
        game.move("U");
        consoleTestUtil.testOutput(
                List.of("[ O |   | O |   ]", "[   | O |   | X ]"),
                (Null) -> outputView.printMap(game));
    }
}