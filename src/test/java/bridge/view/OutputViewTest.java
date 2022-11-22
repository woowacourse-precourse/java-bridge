package bridge.view;

import bridge.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class OutputViewTest {

    @Test
    void printMap_기능구현() {
        OutputView outputView = new OutputView(Arrays.asList("U", "D", "D"));
        outputView.printMap(Arrays.asList("U","D","D"), Arrays.asList("U","D","D"));
    }

    @Test
    void printMap_틀렸을때() {
        OutputView outputView = new OutputView(Arrays.asList("U", "D", "D"));
        outputView.printMap(Arrays.asList("U", "D", "D"), Arrays.asList("U","D","U"));
    }
}