package bridge.view;

import bridge.model.Bridge;
import bridge.model.BridgeNumberGenerator;
import bridge.model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class ViewTest {
    private OutputView outputView = new OutputView();


    @Test
    public void printMapTest(){
        BridgeNumberGenerator numberGenerator = new ViewTest.TestNumberGenerator(newArrayList(1, 0, 0, 1));
        Bridge bridge = new Bridge(4,numberGenerator);
        Player player = new Player(1,4);
        outputView.printMap(bridge,player,"D");
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
