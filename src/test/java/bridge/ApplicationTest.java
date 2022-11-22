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
import org.junit.jupiter.params.provider.*;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_WRONG_BRIDGE_LENGTH_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INPUT_WRONG_BRIDGE_MOVEMENT_MESSAGE = "위 칸으로 이동할 시 'U', 아래 칸으로 이동할 시 'D'를 입력해 주셔야 합니다.";
    private static final String INPUT_WRONG_RETRY_ANSWER_MESSAGE = "게임 재시도 시 'R', 종료 시 'Q'를 입력해 주셔야 합니다.";

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

    @DisplayName("재시도 기능 테스트 - 3번의 시도로 다리 건너기 게임 성공")
    @Test
    void successBridgeGameByMoreThen2Try() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D", "R", "U", "D", "D", "R", "U", "D", "U", "U");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   | O | O ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O | O ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1);
    }

    @DisplayName("게임 끝내기 기능 테스트 - 2번째 시도 후 실패로 게임 끝내기")
    @Test
    void failBridgeGameBy2Try() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D", "R", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1);
    }

    @DisplayName("다리 길이 입력 예외 테스트 - 3 이상, 20 이하의 값 외 입력")
    @NullSource
    @ValueSource(strings = {"   ", "a", "1", "21", "-4", "abc", "123"})
    @ParameterizedTest
    void exceptionInputBridgeLength(String inputBridgeLength) {
        assertSimpleTest(() -> {
            runException(inputBridgeLength);
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    INPUT_WRONG_BRIDGE_LENGTH_MESSAGE
            );
        });
    }

    @DisplayName("이동 입력 예외 테스트 - 'U' 혹은 'D' 이외의 값 입력")
    @NullSource
    @ValueSource(strings = {"   ", "u", "d", "a", "B", "abc", "1", "123"})
    @ParameterizedTest
    void exceptionInputPlayerMove(String inputPlayerMove) {
        assertSimpleTest(() -> {
            runException("4", inputPlayerMove);
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    INPUT_WRONG_BRIDGE_MOVEMENT_MESSAGE
            );
        });
    }

    @DisplayName("재시도 여부 입력 예외 테스트 - 'Q' 혹은 'R' 이외의 값 입력")
    @NullSource
    @ValueSource(strings = {"   ", "q", "r", "a", "B", "abc", "1", "123"})
    @ParameterizedTest
    void exceptionInputRetryGame(String inputRetryGame) {
        assertSimpleTest(() -> {
            runException("4", "D", inputRetryGame);
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    INPUT_WRONG_RETRY_ANSWER_MESSAGE
            );
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
