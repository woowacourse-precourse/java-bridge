package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @DisplayName("무작위 값에 맞는 다리 생성 테스트")
    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D");
    }

    @DisplayName("게임 성공에 대한 출력 테스트")
    @Test
    void 게임_성공_테스트() {
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

    @DisplayName("움직이지 못하는 경우 종료 후 게임 실패에 대한 출력 테스트")
    @Test
    void 게임_실패_테스트() {
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

    @DisplayName("재시작 후 게임 성공에 대한 출력 테스트")
    @Test
    void 게임_재시작_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("재시작 횟수에 따른 게임 횟수 테스트")
    @Test
    void 게임_횟수_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "D", "R", "D", "R", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 4"
            );

            int upSideIndex = output().indexOf("[   ]");
            int downSideIndex = output().indexOf("[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
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