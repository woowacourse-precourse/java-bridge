package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static bridge.support.ErrorMessage.BRIDGE_MAKER_SIZE_ERROR;
import static bridge.support.ErrorMessage.INVALID_MOVE_CODE_ERROR;
import static bridge.support.ErrorMessage.INVALID_COMMAND_ERROR;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ApplicationFunctionalTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | X ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O | X ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0);
    }

    @Test
    void 재시작_후_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex1 = output().indexOf("[ O |   |   ]");
            int downSideIndex1 = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex1).isLessThan(downSideIndex1);

            int upSideIndex2 = output().indexOf("[ O |   | O ]");
            int downSideIndex2 = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex2).isLessThan(downSideIndex2);
        }, 1, 0, 1);
    }

    @Test
    void 재시작_후_실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "R", "U", "R", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ X ]",
                    "[   ]",
                    "[   |   ]",
                    "[ O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex1 = output().indexOf("[ X ]");
            int downSideIndex1 = output().indexOf("[   ]");
            assertThat(upSideIndex1).isLessThan(downSideIndex1);

            int upSideIndex2 = output().indexOf("[   |   ]");
            int downSideIndex2 = output().indexOf("[ O | X ]");
            assertThat(upSideIndex2).isLessThan(downSideIndex2);
        }, 0, 1, 1);
    }

    @Test
    void 다리_길이_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("2", "3", "U", "Q");
            assertThat(output()).contains(
                    ERROR_MESSAGE + " " + BRIDGE_MAKER_SIZE_ERROR,
                    "최종 게임 결과",
                    "[ X ]",
                    "[   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ X ]");
            int downSideIndex = output().indexOf("[   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @Test
    void 이동_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "T", "U", "Q");
            assertThat(output()).contains(
                    ERROR_MESSAGE + " " + INVALID_MOVE_CODE_ERROR,
                    "최종 게임 결과",
                    "[ X ]",
                    "[   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ X ]");
            int downSideIndex = output().indexOf("[   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @Test
    void 커맨드_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "A", "Q");
            assertThat(output()).contains(
                    ERROR_MESSAGE + " " + INVALID_COMMAND_ERROR,
                    "최종 게임 결과",
                    "[ X ]",
                    "[   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ X ]");
            int downSideIndex = output().indexOf("[   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
