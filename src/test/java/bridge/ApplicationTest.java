package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_테스트_모두_위칸인_경우() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "U", "U");
    }

    @Test
    void 다리_생성_테스트_모두_아래칸인_경우() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "D", "D");
    }

    @Test
    void 기능_테스트() {
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

    @Test
    void 기능_테스트_1번_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 기능_테스트_다리를_한_번_건너고_게임_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 기능_테스트_시작하자마자_게임_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[   ]");
            int downSideIndex = output().indexOf("[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 기능_테스트_길이가_5인_다리() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "U", "R", "U", "D", "D", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   | O | O ]",
                    "[   | O | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   |   | O | O ]");
            int downSideIndex = output().indexOf("[   | O | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0, 1, 1);
    }

    @Test
    void 기능_테스트_4번_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "U", "R", "D", "R", "D", "R", "U", "D", "D", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   | O | O ]",
                    "[   | O | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );

            int upSideIndex = output().indexOf("[ O |   |   | O | O ]");
            int downSideIndex = output().indexOf("[   | O | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0, 1, 1);
    }

    @Test
    void 기능_테스트_길이가_7인_다리() {
        assertRandomNumberInRangeTest(() -> {
            run("7", "U", "U", "R", "D", "R", "D", "R", "U", "D", "D", "U", "D", "R", "U", "D", "D", "U", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   | O | O |   | O ]",
                    "[   | O | O |   |   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 5"
            );

            int upSideIndex = output().indexOf("[ O |   |   | O | O |   | O ]");
            int downSideIndex = output().indexOf("[   | O | O |   |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0, 1, 1, 0, 1);
    }

    @Test
    void 기능_테스트_길이가_7인_다리지만_5번째를_건너지_못해서_게임_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("7", "U", "U", "R", "D", "R", "D", "R", "U", "D", "D", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   | O |   ]",
                    "[   | O | O |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 4"
            );

            int upSideIndex = output().indexOf("[ O |   |   | O |   ]");
            int downSideIndex = output().indexOf("[   | O | O |   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0, 1, 1, 0, 1);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
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
