package bridge.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.Constants.BridgeSign.DOWN;
import static bridge.constant.Constants.Error.INPUT_VALUE_FORMAT_ERROR_MESSAGE;
import static bridge.constant.Constants.Error.MOVE_DIRECTION_ERROR_MESSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameControllerTest extends NsTest {

    private BridgeGameController gameController;
    public final String ERROR_PREFIX = "[ERROR] ";

    @BeforeEach
    void setup() {
        gameController = new BridgeGameController();
    }


    @DisplayName("입력받은 다리 길이가 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", "A", " ", "aaa", "\r\n"})
    void bridgeSizeFormatErrorTest(String bridgeSize) {
        assertSimpleTest(() -> {
            runException(bridgeSize);
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("입력받은 다리 길이가 3이상 20이하의 수가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "100", "3000"})
    void bridgeSizeRangeErrorTest(String bridgeSize) {
        assertSimpleTest(() -> {
            runException(bridgeSize);
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }

    @DisplayName("입력받은 이동방향이 U 또는 D가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"z", "w", "ddd", "adawdaw", "AWDW"})
    void movingDirectionErrorTest(String direction) {
        assertRandomNumberInRangeTest(() -> {
            runException("3", direction);
            assertThat(output()).contains(ERROR_PREFIX);
        }, 1, 0, 1);
    }

    @DisplayName("입력받은 재시작 여부가 R 또는 Q가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"z", "w", "ddd", "adawdaw", "AWDW"})
    void retryErrorTest(String isRetry) {
        assertRandomNumberInRangeTest(() -> {
            runException("3", DOWN, isRetry);
            assertThat(output()).contains(ERROR_PREFIX);
        }, 1, 0, 1);
    }

    @DisplayName("게임 성공 테스트")
    @Test
    void gamePassTest() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @DisplayName("게임 실패 테스트")
    @Test
    void gameFailTest() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | X ]",
                    "[   | O |   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   | X ]");
            int downSideIndex = output().indexOf("[   | O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @DisplayName("게임 재시작 테스트")
    @Test
    void gameRetryTest() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "U", "R", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Override
    protected void runMain() {
        gameController.start();
        gameController.end();
    }
}