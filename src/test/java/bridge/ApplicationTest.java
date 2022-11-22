package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 생성 테스트")
    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @DisplayName("다리 건너기 게임 기능 테스트")
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


    @DisplayName("입력 받은 다리의 길이가 정수가 아닌 경우 예외 처리")
    @ValueSource(strings = {"a", "!", "123."})
    @ParameterizedTest
    void notIntInputException(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 받은 다리의 길이가 3과 20사이의 정수가 아닌 경우 예외 처리")
    @ValueSource(strings = {"-1", "50"})
    @ParameterizedTest
    void notInRangeInputException(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 받은 이동할 칸이 U나 D가 아닌 경우 예외 처리")
    @ValueSource(strings = {"1", "A"})
    @ParameterizedTest
    void notAllowedInputException(String input) {
        assertSimpleTest(() -> {
            runException("3", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("입력 받은 재시도 여부가 R이나 Q가 아닌 경우 예외 처리")
    @ValueSource(strings = {"1", "A"})
    @ParameterizedTest
    void notAllowedInputException2(String input) {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "U", input);
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
