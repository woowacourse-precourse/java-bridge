package bridge;

import static bridge.constant.BridgeGameConstant.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 기능_테스트_성공() {
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
    void 기능_테스트_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 기능_테스트_한번_실패후_성공() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 기능_테스트_한번_실패후_실패() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "R", "U", "D", "D", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   | O | X ]",
                    "[   | O | O |   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   |   | O | X ]");
            int downSideIndex = output().indexOf("[   | O | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0, 1, 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1,000", "10j", "3.14", " "})
    void 예외_테스트_다리_길이_입력_정수(String bridgeSize) {
        assertSimpleTest(() -> {
            runException(bridgeSize);
            assertThat(output()).contains(ExceptionMessage.INVALID_BRIDGE_SIZE_ONLY_INTEGER);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "21", "0", "-1", "50"})
    void 예외_테스트_다리_길이_입력_범위(String bridgeSize) {
        assertSimpleTest(() -> {
            runException(bridgeSize);
            assertThat(output()).contains(ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "UD", "abc", "123", "100j"})
    void 예외_테스트_이동할_칸_입력(String moving) {
        assertSimpleTest(() -> {
            runException("3", moving);
            assertThat(output()).contains(ExceptionMessage.INVALID_MOVING);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "RQ", "abc", "123", "100j"})
    void 예외_테스트_게임_재시도_여부_입력(String gameCommand) {
        assertRandomNumberInRangeTest(() -> {
            assertSimpleTest(() -> {
                runException("3", "U", "U", gameCommand);
                assertThat(output()).contains(ExceptionMessage.INVALID_GAME_COMMAND);
            });
        }, 1, 0, 0);
    }

    @Test
    void 잘못된_입력일_경우_재입력후_게임진행() {
        assertRandomNumberInRangeTest(() -> {
            run("abc", "1", "3", "d", "U", "U", "r", "R", "U", "D", "D");
            assertThat(output()).contains(
                    ExceptionMessage.INVALID_BRIDGE_SIZE_ONLY_INTEGER,
                    ExceptionMessage.INVALID_BRIDGE_SIZE_RANGE,
                    ExceptionMessage.INVALID_MOVING,
                    ExceptionMessage.INVALID_GAME_COMMAND,
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 0);
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
