package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.*;

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

    /**
     * custom test
     */
    @Nested
    @DisplayName("입력 예외 테스트")
    class InputExceptionTest {
        @Test
        @DisplayName("길이 2")
        void bridgeSizeShort() {
            assertSimpleTest(() -> {
                runException("2");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        @DisplayName("길이 25")
        void bridgeSizeLong() {
            assertSimpleTest(() -> {
                runException("25");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        @DisplayName("정수가 아닌 길이")
        void bridgeSizeDouble() {
            assertSimpleTest(() -> {
                runException("3.1");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        @DisplayName("문자열 입력")
        void bridgeSizeString() {
            assertSimpleTest(() -> {
                runException("HI");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        @DisplayName("다리 이동 오류")
        void moveNotUD() {
            assertSimpleTest(() -> {
                runException("3", "Q");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        @DisplayName("다리 이동 소문자")
        void moveLowerUD() {
            assertSimpleTest(() -> {
                runException("3", "u");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @Test
        @DisplayName("재시작 소문자")
        void retryLowerRQ() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "D", "r");
                assertThat(output()).contains(ERROR_MESSAGE);
            }, 1);
        }

        @Test
        @DisplayName("재시작 오류")
        void retryNotRQ() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "D", "W");
                assertThat(output()).contains(ERROR_MESSAGE);
            }, 1);
        }
    }
}
