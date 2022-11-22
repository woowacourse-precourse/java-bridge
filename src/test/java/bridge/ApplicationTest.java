package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

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

    @Test
    @DisplayName("다리 길이는 3미만의 수는 예외 처리된다")
    void bridgeLengthTest1() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    @DisplayName("다리 길이는 20초과의 수는 예외 처리된다")
    void bridgeLengthTest2() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    @DisplayName("이동할 칸의 입력은 길이가 1이어야 한다.")
    void moveTest1() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "UD", "U", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }
    @Test
    @DisplayName("이동할 칸의 입력은 U 또는 D")
    void moveTest2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "R", "U", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }
    @Test
    @DisplayName("재시도 여부의 입력은 길이가 1이어야 한다.")
    void retryTest1() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "RQ", "R", "U", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("재시도 여부의 입력은 R 또는 Q")
    void retryTest2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D", "R", "U", "D", "U");
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
