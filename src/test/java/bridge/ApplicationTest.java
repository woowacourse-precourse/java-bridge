package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.util.ExceptionMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Nested;
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

    @Nested
    class runTest {
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
        void 재시작_후_성공_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "D", "R", "U", "U", "D");
                assertThat(output()).contains(
                        "[ O |   ]",
                        "[   | X ]",
                        "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                        "최종 게임 결과",
                        "[ O | O |   ]",
                        "[   |   | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 2"
                );

                int upSideIndex = output().indexOf("[ O | O |   ]");
                int downSideIndex = output().indexOf("[   |   | O ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 1, 0);
        }

        @Test
        void 재시작_후_실패_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "R", "D", "U", "Q");
                assertThat(output()).contains(
                        "[   | X ]",
                        "[ O |   ]",
                        "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                        "최종 게임 결과",
                        "[   | X ]",
                        "[ O |   ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 2"
                );
            }, 0, 0, 1);
        }

        @Test
        void 예외_재입력_후_실패_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("   d", "   12345678   ", "22222222222222222222", "    3   ", "k", "U", "D", "q", "Q");
                assertThat(output()).contains(
                        ExceptionMessage.INVALID_NOT_NUMERIC.getMessage(),
                        ExceptionMessage.INVALID_NOT_IN_RANGE.getMessage(),
                        ExceptionMessage.OUT_OF_INT_RANGE.getMessage(),
                        ExceptionMessage.NO_BRIDGE_DIRECTION_SIGN.getMessage(),
                        ExceptionMessage.INVALID_GAME_COMMAND.getMessage(),
                        "최종 게임 결과",
                        "[ O |   ]",
                        "[   | X ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 1"
                );
            }, 1, 1, 1);
        }
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
