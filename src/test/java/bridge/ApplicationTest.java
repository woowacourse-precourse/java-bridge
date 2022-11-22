package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.bridge.BridgeMaker;
import bridge.bridge.BridgeNumberGenerator;
import bridge.exception.IllegalArgumentExceptionMessage;
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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_생성_짧은_길이_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_LENGTH.getMessage());
        });
    }

    @Test
    void 다리_생성_긴_길이_예외_테스트() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_LENGTH.getMessage());
        });
    }

    @Test
    void 다리_위치_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("4", "D", "U", "U", "A");
            assertThat(output()).contains(IllegalArgumentExceptionMessage.ILLEGAL_BRIDGE_POSITION.getMessage());
        }, 0, 1, 1, 1);
    }

    @Test
    void 게임_재시작_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("4", "D", "U", "U", "D", "T");
            assertThat(output()).contains(IllegalArgumentExceptionMessage.ILLEGAL_GAME_COMMAND.getMessage());
        }, 0, 1, 1, 1);
    }

    @Test
    void 게임_실패_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D", "U", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O | O |   ]",
                    "[ O |   |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 0, 1, 1, 1);
    }
    @Test
    void 게임_실패_재시작_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D", "U", "U", "D", "R", "D", "U", "U", "U");
            assertThat(output()).contains(
                    "[   | O | O |   ]",
                    "[ O |   |   | X ]"
            );

            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O | O | O ]",
                    "[ O |   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 0, 1, 1, 1);
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
