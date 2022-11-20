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
    void compareBridgeToInputTest() {
        List<String> bridge = new ArrayList<>();
        bridge.add("U");
        bridge.add("D");
        bridge.add("D");
        bridge.add("D");

        //틀리면 종료
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

        //다 맞추면 끝
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

        //중간에 잘못된 값이 들어가면 오류 출력하고 다시 실행
        {
            movingProcessing = new MovingProcessing();

            command("U", "D", "W", "D", "D");
            movingProcessing.compareBridgeToInput(bridge);
            assertThat(output()).contains(
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ERROR]",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "[ O |   |   |   ]",
                    "[   | O | O | O ]"
            );
        }

    }

}