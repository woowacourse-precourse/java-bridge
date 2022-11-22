package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static bridge.BridgeGame.count;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("예외 1-1. 3 이상 20 이하의 숫자가 아닌 경우")
    void test0() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("예외 1-2. 숫자가 아닌 경우")
    void test1() {
        assertSimpleTest(() -> {
            runException("문자");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("2-1. 1번 다리 생성")
    void test2() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    @DisplayName("2-2. 2번 다리 생성")
    void test3() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> firstBridge = Arrays.asList("U", "D", "D");
        List<String> bridge = bridgeMaker.makeSecondBridge(firstBridge);
        assertThat(bridge).containsExactly("D", "U", "U");
    }

    @Test
    @DisplayName("예외 3-1. U(위 칸)와 D(아래 칸) 중 하나의 문자가 아닌 경우")
    void test4() {
        assertSimpleTest(() -> {
            runException("3", "R");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName(("4. 사용자가 이동할 때마다 다리 건너기 결과"))
    void test5() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName(("5. 이동할 수 없는 칸을 입력받은 경우에는 게임 재시작/ 종료 여부를 입력"))
    void test6() {
        count = 0;
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            );
            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("예외 5-1. R(재시작)과 Q(종료) 중 하나의 문자가 아닌 경우")
    void test7() {
        count = 0;
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "문자", "Q");
            assertThat(output()).contains(
                    ERROR_MESSAGE
            );

            int upSideIndex = output().indexOf("[ O |   |  ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
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
