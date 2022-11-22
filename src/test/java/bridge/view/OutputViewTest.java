package bridge.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @Test
    void printMapTest() {
        assertSimpleTest(() -> {
            List<String> upBridge = List.of("O", " ", "X");
            List<String> downBridge = List.of(" ", "O", " ");
            new OutputView().printMap(upBridge, downBridge);
            assertThat(output()).contains(
                    "[ O |   | X ]",
                    "[   | O |   ]"
            );
        });
    }

    @Override
    protected void runMain() {

    }
}