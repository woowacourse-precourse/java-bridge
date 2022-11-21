package bridge.ioView;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final OutputView outputView = new OutputView();

    @DisplayName("printMap_실패")
    @Test
    void printMap_실패() {
        List<String> userRoute = Arrays.asList("U","D","U","D","U","D");
        List<String> bridge = Arrays.asList("U","D","U","D","U","U");

        outputView.printMap(userRoute, bridge);

        assertThat(output()).contains(
                "[ O |   | O |   | O |   ]",
                "[   | O |   | O |   | X ]"
        );

        int upSideIndex = output().indexOf("[ O |   | O |   | O |   ]");
        int downSideIndex = output().indexOf("[   | O |   | O |   | X ]");

        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("printMap_성공")
    @Test
    void printMap_성공() {
        List<String> userRoute = Arrays.asList("U","D","U","D","U","U");
        List<String> bridge = Arrays.asList("U","D","U","D","U","U");

        outputView.printMap(userRoute, bridge);

        assertThat(output()).contains(
                "[ O |   | O |   | O | O ]",
                "[   | O |   | O |   |   ]"
        );

        int upSideIndex = output().indexOf("[ O |   | O |   | O | O ]");
        int downSideIndex = output().indexOf("[   | O |   | O |   |   ]");

        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("printResult_실패")
    @Test
    void printResult_실패() {
        int trial = 1234;
        List<String> userRoute = Arrays.asList("U","D","U","D","U","D");
        List<String> bridge = Arrays.asList("U","D","U","D","U","U");

        outputView.printResult(trial, userRoute, bridge);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O |   | O |   ]",
                "[   | O |   | O |   | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1234"
        );

        int upSideIndex = output().indexOf("[ O |   | O |   | O |   ]");
        int downSideIndex = output().indexOf("[   | O |   | O |   | X ]");

        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("printResult_성공")
    @Test
    void printResult_성공() {
        int trial = 1234;
        List<String> userRoute = Arrays.asList("U","D","U","D","U","U");
        List<String> bridge = Arrays.asList("U","D","U","D","U","U");

        outputView.printMap(userRoute, bridge);

        outputView.printResult(trial, userRoute, bridge);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O |   | O | O ]",
                "[   | O |   | O |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1234"
        );

        int upSideIndex = output().indexOf("[ O |   | O |   | O | O ]");
        int downSideIndex = output().indexOf("[   | O |   | O |   |   ]");

        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}