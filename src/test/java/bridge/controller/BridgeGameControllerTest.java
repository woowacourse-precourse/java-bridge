package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class BridgeGameControllerTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("이동할 칸의 값이 U와 D가 아닌 다른 문자가 포함될 때 예외메시지가 출력된다.")
    @ValueSource(strings = {"UDT", "DDP", "33", "200FF", "U23"})
    @ParameterizedTest
    void testThrowingExceptionWhenInvalidBlockInput(String blockToMove) {
        assertSimpleTest(() -> {
            runException("3", blockToMove);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("게임을 2회 시도하여 성공했을 때 성공 여부인 성공과 총 시도한 횟수가 2회 출력된다.")
    @Test
    void testFinalResultHasCorrectTrial() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "U", "D", "R", "U", "D", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | O ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O | O ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1);
    }

    @DisplayName("게임을 2회 시도하여 실패하고 종료했을 때 성공여부인 실패와 총 시도한 횟수가 2회 출력된다.")
    @Test
    void testFinalResultHasCorrectTrialWhenFail() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("위, 아래, 위, 위 순서의 다리를 정확하게 건너면 게임을 성공한다.")
    @Test
    void testFinalResultIsSuccess() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | O ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O | O ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1);
    }

    @DisplayName("위, 아래, 아래, 위 순서의 다리를 정확하게 건너지 못하고 종료하면 게임을 실패한다.")
    @Test
    void testFinalResultIsFail() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   |   ]",
                    "[   | O | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}