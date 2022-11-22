package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.BridgeLength;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMove;
import bridge.domain.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        List<Integer> moveCodes = new ArrayList<>(Arrays.asList(1, 0, 0));
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(moveCodes);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = bridgeMaker.makeBridge(new BridgeLength(3));
        List<BridgeMove> actualMoveCodes = new ArrayList<>();
        bridge.iterator().forEachRemaining(actualMoveCodes::add);
        assertThat(actualMoveCodes).containsExactly(BridgeMove.UP, BridgeMove.DOWN, BridgeMove.DOWN);
    }

    @ParameterizedTest(name = "기능테스트:{0}")
    @MethodSource
    void 기능_테스트(String[] args, String[] outputs, String upside, String downSide) {
        assertRandomNumberInRangeTest(() -> {
            run(args);
            assertThat(output()).contains(outputs);

            int upSideIndex = output().indexOf(upside);
            int downSideIndex = output().indexOf(downSide);
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1, 0);
    }

    private static Stream<Arguments> 기능_테스트() {
        return Stream.of(
                Arguments.of(
                        new String[]{"5", "U", "D", "U", "U", "D"},
                        new String[]{
                                "최종 게임 결과",
                                "[ O |   | O | O |   ]",
                                "[   | O |   |   | O ]",
                                "게임 성공 여부: 성공",
                                "총 시도한 횟수: 1"
                        },
                        "[ O |   | O | O |   ]",
                        "[   | O |   |   | O ]"
                ),
                Arguments.of(
                        new String[]{"5", "D", "Q"},
                        new String[]{
                                "최종 게임 결과",
                                "[   ]",
                                "[ X ]",
                                "게임 성공 여부: 실패",
                                "총 시도한 횟수: 1"},
                        "[   ]",
                        "[ X ]"
                ),
                Arguments.of(
                        new String[] {"3", "U", "D", "U"},
                        new String[] {
                                "최종 게임 결과",
                                "[ O |   | O ]",
                                "[   | O |   ]",
                                "게임 성공 여부: 성공",
                                "총 시도한 횟수: 1"},
                        "[ O |   | O ]",
                        "[   | O |   ]"
                ),
                Arguments.of(
                        new String[] {"5", "D", "R", "U", "D", "D", "Q"},
                        new String[] {
                                "최종 게임 결과",
                                "[ O |   |   ]",
                                "[   | O | X ]",
                                "게임 성공 여부: 실패",
                                "총 시도한 횟수: 2"},
                        "[ O |   |   ]",
                        "[   | O | X ]"
                        )
        );
    }

    @ParameterizedTest(name = "예외 테스트{0}")
    @ValueSource(strings = {"a", "21,2", "3,X"})
    void 예외_테스트(String arg) {
        String[] args = arg.split(",");
        assertSimpleTest(() -> {
            runException(args);
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
