package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class OutputViewTest extends CustomNsTest {

    private final OutputView outputView = new OutputView();

    @Test
    @DisplayName("현재 다리 상황 출력 테스트")
    void printMapTest() {

        //위 1, 3 아래 2 맞췄을 때
        {
            List<String> upSide = List.of("O", " ", "O");
            List<String> downSide = List.of(" ", "O", " ");

            outputView.printMap(upSide, downSide);
            assertThat(output()).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        }

        //위 1, 2, 3 맞췄을 때
        {
            List<String> upSide = List.of("O", "O", "O");
            List<String> downSide = List.of(" ", " ", " ");

            outputView.printMap(upSide, downSide);
            assertThat(output()).contains(
                    "[ O | O | O ]",
                    "[   |   |   ]"
            );
        }

        //아래 1, 2, 3 맞췄을 때
        {
            List<String> upSide = List.of(" ", " ", " ");
            List<String> downSide = List.of("O", "O", "O");

            outputView.printMap(upSide, downSide);
            assertThat(output()).contains(
                    "[   |   |   ]",
                    "[ O | O | O ]"
            );
        }

        //중간에 하나 틀렸을 때
        {
            List<String> upSide = List.of("O", " ");
            List<String> downSide = List.of(" ", "X");

            outputView.printMap(upSide, downSide);
            assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | X ]"
            );
        }
    }

    @Test
    @DisplayName("최종 결과 출력 테스트")
    void printResult() {

        //번갈아 가며 맞았을 경우
        {
            String upSideBridge = "[ O |   | O ]";
            String downSideBridge = "[   | O |   ]";
            int count = 2;

            outputView.printResult(upSideBridge, downSideBridge, count);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }

        //윗줄 다 맞았을 경우
        {
            String upSideBridge = "[ O | O | O ]";
            String downSideBridge = "[   |   |   ]";
            int count = 3;

            outputView.printResult(upSideBridge, downSideBridge, count);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O | O ]",
                    "[   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );
        }

        //아랫줄 다 맞았을 경우
        {
            String upSideBridge = "[   |   |   ]";
            String downSideBridge = "[ O | O | O ]";
            int count = 4;

            outputView.printResult(upSideBridge, downSideBridge, count);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   |   |   ]",
                    "[ O | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );
        }

        //중간에 틀렸을 경우
        {
            String upSideBridge = "[   | X ]";
            String downSideBridge = "[ O |   ]";
            int count = 5;

            outputView.printResult(upSideBridge, downSideBridge, count);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | X ]",
                    "[ O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 5"
            );
        }

    }
}