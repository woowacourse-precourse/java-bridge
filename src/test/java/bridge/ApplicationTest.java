package bridge;

import bridge.support.BridgeMaker;
import bridge.support.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

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

    @Nested
    @DisplayName("예외 테스트")
    class exceptionTest {

        @Nested
        @DisplayName("잘못된 다리길이 입력")
        class bridgeSize {
            @DisplayName(" (숫자가 아닌값이면 예외)")
            @ParameterizedTest(name = "입력값: {0}")
            @CsvSource({"a", "1000j", "hwll", "13L"})
            void invalidInput(String input) {
                assertSimpleTest(() -> {
                    runException(input);
                    assertThat(output()).contains(ERROR_MESSAGE);
                });
            }

            @DisplayName(" (3 ~ 20 범위 내 숫자가 아니면 예외)")
            @ParameterizedTest(name = "입력값: {0}")
            @CsvSource({"1", "-2", "1233", "21"})
            void wrongBridgeSize(String input) {
                assertSimpleTest(() -> {
                    runException(input);
                    assertThat(output()).contains(ERROR_MESSAGE);
                });
            }
        }

        @DisplayName("이동에 잘못된 입력 (입력값이 U, D가 아니면 예외)")
        @ParameterizedTest(name = "입력값: {0}")
        @CsvSource({"a", "Uu", "d", "u", "1"})
        void invalidMoving(String input) {
            assertSimpleTest(() -> {
                runException("3", input);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @DisplayName("게임 재시작에 잘못된 입력 (입력값이 R, Q가 아니면 예외)")
        @ParameterizedTest(name = "입력값: {0}")
        @CsvSource({"Rr", "r", "Quit", "q"})
        void invalidGameCommand(String input) {
            assertRandomNumberInRangeTest(() -> {
                runException("3", "U", "U", input);
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
