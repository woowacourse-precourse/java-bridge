package bridge;

import static bridge.constant.ErrorMessage.BRIDGE_MARK_TO_MOVE_IS_NOT_IN_RANGE;
import static bridge.constant.ErrorMessage.RETRY_COMMAND_IS_NOT_IN_RANGE;
import static bridge.constant.InformationMessage.INPUT_BRIDGE_MOVE_RETRY;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeColumn;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeMoverTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void 결과맵_초기화() {
        BridgeColumn.clearAllResultMap();
    }

    @Test
    void 예외_테스트_이동할_칸이_U나_D가_아닐때() {
        assertSimpleTest(() -> {
            runException("5", "F");
            assertThat(output()).contains(ERROR_MESSAGE);
            assertThat(output()).contains(BRIDGE_MARK_TO_MOVE_IS_NOT_IN_RANGE);
        });
    }

    @Test
    void 기능_테스트_이동할때마다_현재_건넌_다리까지_맵_출력() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]"
            );
            assertThat(output()).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
            assertThat(output()).contains(
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 기능_테스트_이동이_불가능할_경우_X로_표시() {
        assertRandomNumberInRangeTest(() -> {
            runException("5", "U", "D", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O |   | O |   | X ]",
                    "[   | O |   | O |   ]",
                    INPUT_BRIDGE_MOVE_RETRY
            );

            int upSideIndex = output().indexOf("[ O |   | O |   | X ]");
            int downSideIndex = output().indexOf("[   | O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 기능_테스트_다리_게임_실패_후_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "R", "U", "U", "D");
            assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | X ]",
                    INPUT_BRIDGE_MOVE_RETRY
            );
            assertThat(output()).contains(
                    "[ O | O |   ]",
                    "[   |   | O ]"
            );
            int upSideIndex = output().indexOf(INPUT_BRIDGE_MOVE_RETRY);
            int downSideIndex = output().indexOf("[   |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0);
    }

    @Test
    void 기능_테스트_다리_게임_실패_후_종료() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "Q");
            assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | X ]",
                    INPUT_BRIDGE_MOVE_RETRY
            );
        }, 1, 1, 0);
    }

    @Test
    void 예외_테스트_재시작_여부_입력값이_R이나_Q가_아닐때() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "D", "F");
            assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | X ]",
                    INPUT_BRIDGE_MOVE_RETRY
            );
            assertThat(output()).contains(RETRY_COMMAND_IS_NOT_IN_RANGE);
            int upSideIndex = output().indexOf(INPUT_BRIDGE_MOVE_RETRY);
            int downSideIndex = output().indexOf(RETRY_COMMAND_IS_NOT_IN_RANGE);
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}