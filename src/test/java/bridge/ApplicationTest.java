package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.Streams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
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
    void 틀린_움직임_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3","D", "R", "U", "U", "R", "D", "U");
            assertThat(output()).contains(
                    "총 시도한 횟수: 3",
                    "[ X ]",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 성공"
            );
        }, 1, 0, 1);
    }

    @Test
    void 도중_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3","D", "R", "U", "U", "Q");
            assertThat(output()).contains(
                    "총 시도한 횟수: 2",
                    "[ X ]",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패"
            );
        }, 1, 0, 1);
    }

    @DisplayName("다리 길이에 대한 예외처리")
    @ValueSource(strings = {"a", "0", "22"})
    @ParameterizedTest
    void 다리_길이_예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("움직임에 대한 예외처리")
    @ValueSource(strings = {"a", "0", "22"})
    @ParameterizedTest
    void 움직임_예외_테스트(String input) {
        assertRandomNumberInRangeTest(() -> {
            run("3", input, "U", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1,0, 1);
    }

    @DisplayName("재시작 대한 예외처리")
    @ValueSource(strings = {"a", "0", "22"})
    @ParameterizedTest
    void 재시작_예외_테스트(String input) {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", input, "R", "U", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1,0, 1);
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
