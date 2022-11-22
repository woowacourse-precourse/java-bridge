package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    class FunctionTest {
        @Test
        void 기능_테스트_한번에_성공() {
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
        void 기능_테스트_첫도전_실패() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "D", "D", "Q");
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[ O |   |   ]",
                        "[   | O | X ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[ O |   |   ]");
                int downSideIndex = output().indexOf("[   | O | X ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }

        @Test
        void 기능_테스트_재도전_후_성공() {
            assertRandomNumberInRangeTest(() -> {
                run("4", "U", "D", "D", "R",
                        "D", "R",
                        "U", "D", "U", "D");
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[ O |   | O |   ]",
                        "[   | O |   | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 3"
                );

                int upSideIndex = output().indexOf("[ O |   | O |   ]");
                int downSideIndex = output().indexOf("[   | O |   | O ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1, 0);
        }

        @Test
        void 기능_테스트_세_번_재도전_후_실패() {
            assertRandomNumberInRangeTest(() -> {
                run("6", "U", "D", "R",
                        "U", "U", "D", "R",
                        "U", "U", "U", "D", "D", "R",
                        "U", "U", "U", "D", "U", "U", "Q");
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[ O | O | O |   | O | X ]",
                        "[   |   |   | O |   |   ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 4"
                );

                int upSideIndex = output().indexOf("[ O | O | O |   | O | X ]");
                int downSideIndex = output().indexOf("[   |   |   | O |   |   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 1, 1, 0, 1, 0);
        }
    }

    @Nested
    class ExceptionTest {
        @Test
        void 다리_길이_숫자_아닌_입력_테스트() {
            assertSimpleTest(() -> {
                runException("a");
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"-5", "2", "25"})
        void 다리_길이_범위_초과_테스트(String number) {
            assertSimpleTest(() -> {
                runException(number);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @CsvSource(value = {"3:x", "3:2", "3:-D", "3:u"}, delimiter = ':')
        void 방향_올바르지_않은_입력_테스트(String number, String direction) {
            assertSimpleTest(() -> {
                runException(number, direction);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "3", "r", "q"})
        void 재시작_종료_올바르지_않은_입력_테스트(String restartOrQuit) {
            assertRandomNumberInRangeTest(() -> {
                runException("3", "U", "D", "D", restartOrQuit);
                assertThat(output()).contains(ERROR_MESSAGE);
            }, 1, 0, 1);
        }
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
