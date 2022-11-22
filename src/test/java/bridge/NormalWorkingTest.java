package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NormalWorkingTest extends NsTest {
    @Test
    void 길이가_10인_다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(
                newArrayList(1, 0, 0, 1, 0, 1, 1, 1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(10);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "U", "U", "U", "D", "D");
    }

    @Test
    void 길이가_20인_다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(
                newArrayList(1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsExactly("U", "D", "D", "U", "D", "U", "U", "U", "D", "D", "U", "D", "U", "U", "U",
                "U", "D", "D", "U", "D");
    }

    @Test
    void 총_시도한_횟수가_1번인_게임_성공_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 총_시도한_횟수가_1번인_게임_실패_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | X ]",
                    "[   | O |   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   | X ]");
            int downSideIndex = output().indexOf("[   | O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 총_시도한_횟수가_2번인_게임_성공_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "U", "R", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 총_시도한_횟수가_2번인_게임_실패_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "D", "R", "U", "D", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | X ]",
                    "[   | O |   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   | X ]");
            int downSideIndex = output().indexOf("[   | O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
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
