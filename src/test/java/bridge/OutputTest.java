package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class OutputTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 재시작했을때() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "R", "U", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O | O ]",
                    "[   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2");
            int upSideIndex = output().indexOf("[ O | O | O ]");
            int downSideIndex = output().indexOf("[   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1);
    }

    @Test
    void 중지했을때() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   ]",
                    "[   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1");
        }, 1, 1, 1);
    }

    @Test
    void 예외_테스트_문자_입력() {
        assertSimpleTest(() -> {
            runException("3" , "q");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_범위초과() {
        assertSimpleTest(() -> {
            runException("34");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_재시작() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "D", "T");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 1, 1);
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