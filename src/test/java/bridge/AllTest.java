package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class AllTest extends NsTest {

    @DisplayName("기능 테스트 1")
    @Test
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @DisplayName("기능 테스트 2")
    @Test
    void 기능_테스트2() {
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

    @DisplayName("기능 테스트 3 : 다리 수 10개, 시도 4회")
    @Test
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "R",
                    "U", "U", "R",
                    "U", "U", "R",
                    "U", "D", "U", "D", "U",
                    "D", "U", "D", "U", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   | O |   | O |   ]",
                    "[   | O |   | O |   | O |   | O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );

            int upSideIndex = output().indexOf(
                    "[ O |   | O |   | O |   | O |   | O |   ]");
            int downSideIndex = output().indexOf(
                    "[   | O |   | O |   | O |   | O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }

}
