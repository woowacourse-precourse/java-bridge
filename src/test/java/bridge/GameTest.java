package bridge;

import bridge.constants.ErrorMessage;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest extends NsTest {

    @DisplayName("실패 테스트")
    @Test
    void failure_test() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D","Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }
    @DisplayName("재시도 테스트")
    @Test
    void retry_success_test() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D", "U", "U", "R", "D", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O |   | O ]",
                    "[ O |   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            int upSideIndex = output().indexOf("[   | O |   | O ]");
            int downSideIndex = output().indexOf("[ O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 0, 1);
    }
    @DisplayName("예외 재시도 값으로 non-valid String Command 테스트")
    @Test
    void exception_retry_String_test() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "U", "E");
            assertThat(output()).contains(ErrorMessage.ERROR_NOT_VALID_COMMAND.getDescription());
            }, 0, 1, 0);
    }
    @DisplayName("예외 재시도 값으로 integer Command 테스트")
    @Test
    void exception_retry_integer_test() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "U", "5");
            assertThat(output()).contains(ErrorMessage.ERROR_NOT_VALID_COMMAND.getDescription());
        }, 0, 1, 0);
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
