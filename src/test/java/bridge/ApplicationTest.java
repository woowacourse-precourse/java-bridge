package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.util.BridgeMaker;
import bridge.util.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("네 칸짜리 다리 건너기를 실패 후 종료한다.")
    @Test
    void applicationTest() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "U", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O | O | X ]",
                    "[   |   |   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O | O | O | X ]");
            int downSideIndex = output().indexOf("[   |   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1, 0);
    }

    @DisplayName("범위를 초과한 다리 길이 입력 시 예외를 발생한다.")
    @Test
    void bridgeSizeInputByOverRange() {
        assertSimpleTest(() -> {
            runException("30");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 위, 아래 입력 시 U 또는 D가 아닌 경우 예외를 발생한다.")
    @Test
    void movingInputByNotUOrD() {
        assertSimpleTest(() -> {
            runException("3", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("재시도 또는 종료 시 R 또는 Q가 아닌 경우 예외를 발생한다.")
    @Test
    void gameCommandInputByNotROrQ() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "U", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
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
