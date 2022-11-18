package bridge.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    @Test
    public void printMapTest() throws Exception{
        List<String> bridge = List.of("U","U","D","U","D");
        OutputView outputView = new OutputView(bridge);
        outputView.printMap(0);
        outputView.printMap(0);
        outputView.printMap(0);
        outputView.printMap(0);
        StringBuilder result = new StringBuilder("[ o | o |   | o |   ]\n");
        result.append("[   |   | o |   | o ]");
        Assertions.assertEquals(outputView.printMap(0),result.toString());
    }

}