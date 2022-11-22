package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class GameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D","Q");
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
    @Test
    void 재시도_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D", "U", "U", "R", "D", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O |   | O ]",
                    "[ O |   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            int upSideIndex = output().indexOf("[   | O |   | O ]");
            int downSideIndex = output().indexOf("[ O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 0, 1);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
