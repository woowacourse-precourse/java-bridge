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
    void 통합_테스트_성공() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | X ]",
                    "[   |   ]",
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 0);
    }

    @Test
    void 통합_테스트_재시도_성공() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "R", "U", "D", "D","U","U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | X ]",
                    "[   | O |   ]",
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "[ O |   |   | O ]",
                    "[   | O | O |   ]",
                    "[ O |   |   | O | O ]",
                    "[   | O | O |   |   ]",
                    "최종 게임 결과",
                    "[ O |   |   | O | O ]",
                    "[   | O | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 0, 1, 1);
    }

    @Test
    void 통합_테스트_재시도_여러번_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R","D","R","D","Q");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | X ]",
                    "[   |   ]",
                    "[   ]",
                    "[ X ]",
                    "[   ]",
                    "[ X ]",
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );
        }, 1, 0, 0);
    }

    @Test
    void 통합_테스트_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | X ]",
                    "[   |   ]",
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0);
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
