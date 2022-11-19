package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CustomApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트_실패_후_재시작_성공() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            int upSideFailIndex = output().indexOf("[ O |   |   ]");
            int downSideFailIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideFailIndex).isLessThan(downSideFailIndex);

            int upSideSuccessIndex = output().indexOf("[ O |   | O ]");
            int downSideSuccessIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideSuccessIndex).isLessThan(downSideSuccessIndex);
        }, 1, 0, 1);
    }

    @Test
    void 기능_테스트_실패_후_포기_실패() {
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
