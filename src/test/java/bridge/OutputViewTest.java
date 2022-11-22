package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest extends NsTest {
    OutputView outputView = new OutputView();
    List<String> userInputResultSuccess = List.of("U", "U", "D", "D", "D");
    List<String> userInputResultFail = List.of("U", "D", "DF");

    @Test
    @DisplayName("출려 테스트")
    void printMapTest() {
        run();
        assertThat(output()).contains(
                "[ O | O |   |   |   ]",
                "[   |   | O | O | O ]",
                "[ O |   |   ]",
                "[   | O | X ]"
        );
    }

    @Override
    protected void runMain() {
        outputView.printMap(userInputResultSuccess);
        outputView.printMap(userInputResultFail);
    }
}