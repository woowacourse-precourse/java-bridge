package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class OutputViewTest extends CustomNsTest {

    private final OutputView outputView = new OutputView();

    @Test
    @DisplayName("현재 다리 상황 출력 테스트")
    void printMapTest(){

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



}