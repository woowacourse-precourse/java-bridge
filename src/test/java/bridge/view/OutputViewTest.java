package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
    }

    @Nested
    class PrintMapTest extends NsTest {
        List<String> inputMap;

        @Test
        @DisplayName("")
        public void printMap() {
            inputMap = List.of("OO X", "  O ");
            assertSimpleTest(() -> {
                        run();
                        assertThat(output()).contains(
                                "[ O | O |   | X ]",
                                "[   |   | O |   ]"
                        );
                    }
            );
        }

        @Override
        protected void runMain() {
            outputView.printMap(inputMap);
        }
    }
}