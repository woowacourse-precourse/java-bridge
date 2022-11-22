package bridge;

import bridge.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.List;

class OutputViewTest {

    @Test
    void printMap() {
        OutputView outputView = new OutputView();
        List<String> map = List.of("U", "D", "D");
        List<String> step = List.of("U", "D", "D");
        outputView.printMap(map, step);
    }

}