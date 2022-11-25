package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {

    @DisplayName("다리 건너기 성공")
    @Test
    void cross_Bridge_Success() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U","U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O | O ]",
                    "[   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 1);
    }

    @DisplayName("다리 건너기 실패 후 종료")
    @Test
    void cross_Bridge_Fail_Exit() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U","U","Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O | X ]",
                    "[   |   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 0);
    }

    @DisplayName("다리 건너기 실패 후 재시작 후 성공")
    @Test
    void cross_Bridge_Fail_Retry_Success() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U","U","R","U","U","D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O |   ]",
                    "[   |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 1, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
