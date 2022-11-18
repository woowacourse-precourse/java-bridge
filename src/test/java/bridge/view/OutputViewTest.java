package bridge.view;

import bridge.utill.TestBridgeGenerator;
import bridge.model.BridgeGame;
import bridge.utill.ConsoleTestUtil;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    private static List<String> directions = new ArrayList<>();

    @Test
    @DisplayName("이동 결과 테스트")
    public void printMove(){
        directions = List.of("D", "U", "D", "D");
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("[   | O |   |   ]", "[ O |   | O | X ]");
        });
    }

    @Test
    @DisplayName("이동 결과 테스트")
    public void printMove2(){
        directions = List.of("D", "D");
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("[   |   ]", "[ O | X ]");
        });
    }

    @Override
    protected void runMain() {
        main(new String[]{});
    }

    public static void main(String[] args) {
        TestBridgeGenerator testBridgeGenerator = new TestBridgeGenerator();
        OutputView outputView = new OutputView();

        List<String> bridge = testBridgeGenerator.generate(List.of(0, 1, 0, 1, 0, 1));
        BridgeGame game = new BridgeGame(bridge);

        for (String direction : directions) {
            game.move(direction);
            outputView.printMap(game, direction);
            System.out.println(game.currentBridge());
        }
    }
}