package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameControllerTest extends NsTest {

    @DisplayName("게임 성공에 대해 출력한다.")
    @Test
    void print_success_result() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("게임 실패에 대해 출력한다.")
    @Test
    void print_failure_result() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("총 시도한 횟수에 대해 출력한다.")
    @Test
    void print_number_of_retry() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}