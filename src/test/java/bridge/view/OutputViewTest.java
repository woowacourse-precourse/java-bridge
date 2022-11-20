package bridge.view;

import bridge.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest extends NsTest {

    @Test
    void printMapTest() {
        List<String> bridge = List.of("U", "D", "D", "U");
        List<String> player = List.of("U", "D", "U");
        new OutputView().printMap(bridge, player);
        assertThat(output()).contains(
                "[ O |   | X ]",
                "[   | O |   ]"
        );
    }

    @Override
    protected void runMain() {

    }
}