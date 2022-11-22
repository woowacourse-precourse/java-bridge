package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RunningGameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트_1() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   ]",
                    "[   | O |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O |   | O |   ]");
            int downSideIndex = output().indexOf("[   | O |   | X ]");

            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1, 0);
    }

    @Test
    void 기능_테스트_2() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "R", "U", "D", "U", "U", "D");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   | O | O |   ]",
                    "[   | O |   |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            int upSideIndex = output().indexOf("[ O |   | O | O |  ]");
            int downSideIndex = output().indexOf("[   | O |   |   | O ]");

            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
