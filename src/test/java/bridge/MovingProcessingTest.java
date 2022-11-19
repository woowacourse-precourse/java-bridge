package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

class MovingProcessingTest extends CustomNsTest {

    private MovingProcessing movingProcessing;

    @Test
    @DisplayName("")
    void matchInputTest() {
        List<String> bridge = new ArrayList<>();
        bridge.add("U");
        bridge.add("D");
        bridge.add("D");
        bridge.add("D");

        {
            movingProcessing = new MovingProcessing();

            command("U", "D", "U");
            movingProcessing.compareBridgeToInput(bridge);
            assertThat(output()).contains(
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | X ]",
                    "[   | O |   ]");
        }

        {
            movingProcessing = new MovingProcessing();

            command("U", "D", "D", "D");
            movingProcessing.compareBridgeToInput(bridge);
            assertThat(output()).contains(
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "[ O |   |   |   ]",
                    "[   | O | O | O ]"
            );
        }

    }

}