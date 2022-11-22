package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationRunTest extends NsTest {

    @Test
    @DisplayName("게임이 끝났을 때 재시도 여부를 묻는가?")
    void quest_retry() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("게임이 재시작되어 반복 되어도 잘 돌아가고 성공시 잘 돌아가는가?")
    void retry_successfully() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "R", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("게임 실패 후 재시작되어 반복 되어도 잘 돌아가고 성공시 잘 돌아가는가?")
    void fail_retry_successfully() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("게임이 재시작되어 반복 되어도 잘 돌아가고 실패시 잘 돌아가는가?")
    void retry_fail() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "R", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

