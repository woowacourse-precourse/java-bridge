package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.util.List;

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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리길이_최대값_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("20", "U", "U", "D", "D", "U", "D", "U", "D", "U", "U",
                    "U", "U", "D", "U", "D", "D", "U", "D", "U", "U");
            assertThat(output()).contains(
                    "[ O | O |   |   | O |   | O |   | O | O | O | O |   | O |   |   | O |   | O | O ]",
                    "[   |   | O | O |   | O |   | O |   |   |   |   | O |   | O | O |   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1);
    }

    @Test
    void 게임_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "U", "U", "D", "D", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "[ O | O |   |   | O |   |   ]",
                    "[   |   | O | O |   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1);
    }

    @Test
    void 게임_재시도_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "U", "U", "D", "D", "U", "D", "D", "R",
                    "U", "U", "D", "D", "U", "D", "U","D","U","U" );
            assertThat(output()).contains(
                    "[ O | O |   |   | O |   |   ]",
                    "[   |   | O | O |   | O | X ]",
                    "[ O | O |   |   | O |   | O |   | O | O ]",
                    "[   |   | O | O |   | O |   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1);
    }

    @Test
    void 사용자가_다리길이를_잘못_입력_후_정상작동_테스트(){
        assertRandomNumberInRangeTest(() -> {
            run("a", "3", "U", "D", "D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 0);
    }

    @Test
    void 사용자가_이동선택을_잘못_입력_후_정상작동_테스트(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "Q", "D", "D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 0);
    }

    @Test
    void 사용자가_재시도를_잘못_입력_후_정상작동_테스트(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "U", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]",
                    ERROR_MESSAGE,
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 0);
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
