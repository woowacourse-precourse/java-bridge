package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.message.ErrorMessage;
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
    void 재시작_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "R", "U", "D", "Q");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | X ]",
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | X ]",
                    "최종 게임 결과",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   ]");
            int downSideIndex = output().indexOf("[   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1, 1, 1);
    }

    @Test
    void 재시작_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "U", "D", "R", "U", "U", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | O ]",
                    "[   |   ]",
                    "[ O | O |   ]",
                    "[   |   | X ]",
                    "[ O ]",
                    "[   ]",
                    "[ O | O ]",
                    "[   |   ]",
                    "[ O | O | O ]",
                    "[   |   |   ]",
                    "[ O | O | O |   ]",
                    "[   |   |   | O ]",
                    "[ O | O | O |   | O ]",
                    "[   |   |   | O |   ]",
                    "최종 게임 결과",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O | O | O |   | O ]");
            int downSideIndex = output().indexOf("[   |   |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1, 0, 1);
    }

    @Test
    void 발판_숫자_입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "1");
            assertThat(output()).contains(ErrorMessage.NOT_MOVE_VALID_STRING.getMessage());
        });
    }

    @Test
    void 발판_다른문자_입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "T");
            assertThat(output()).contains(ErrorMessage.NOT_MOVE_VALID_STRING.getMessage());
        });
    }

    @Test
    void 재시작_숫자_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "2");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    ErrorMessage.NOT_RESTART_QUICK_VALID_STRING.getMessage()
            );
        }, 1, 1, 1);
    }

    @Test
    void 재시작_다른문자_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "E");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    ErrorMessage.NOT_RESTART_QUICK_VALID_STRING.getMessage());
        }, 1, 1, 1);
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
