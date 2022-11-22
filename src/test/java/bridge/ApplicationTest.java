package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.controller.InputController;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

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

    @DisplayName("입력 예외 테스트")
    class ExceptionTest {
        @ParameterizedTest
        @DisplayName("- 다리길이 예외 발생.")
        @ValueSource(strings = {"1","22",""})
        void wrongBridgeLengthInput(String input) {
            assertSimpleTest(() -> {
                InputController.init();
                runException(input);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @DisplayName("- 방향 입력 예외 발생.")
        @ValueSource(strings = {"1","H",""})
        void wrongInput(String input) {
            assertSimpleTest(() -> {
                InputController.init();
                runException("3", input);
                assertThat(output()).contains(ERROR_MESSAGE);
            });
        }

        @ParameterizedTest
        @DisplayName("- 재시작 입력 예외 발생.")
        @ValueSource(strings = {"1","H",""})
        void wrongRestartInput(String input) {
            assertRandomNumberInRangeTest(() -> {
                InputController.init();
                runException("D","U","D", input);
                assertThat(output()).contains(ERROR_MESSAGE);
            }, 0,1,1);
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
