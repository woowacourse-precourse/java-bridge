package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameProcessTest extends NsTest {
    ApplicationContext context = new ApplicationContext();
    GameProcess process;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void setUp() {
        process = context.process();
    }

    @Test
    void 게임_진행_클리어() {
        assertRandomNumberInRangeTest(() -> {
            run("x", "7", "U", "D", "D", "R",
                    "U", "D", "U", "U", "-", "R",
                    "a", "b", "U", "D", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   |   ]",
                    "[   | O |   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 0);
    }

    @Test
    void 게임_진행_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("x", "7", "U", "D", "D", "R",
                    "U", "D", "U", "U", "-", "Q",
                    "a", "b", "U", "D", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O |   | O | X ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O | X ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}