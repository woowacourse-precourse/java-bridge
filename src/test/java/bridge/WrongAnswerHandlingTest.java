package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WrongAnswerHandlingTest extends NsTest {
    @Test
    @DisplayName("틀린 후 게임을 바로 종료했을 때 제대로 결과가 나오는 지 확인한다.")
    void quitAfterWrongAnswerTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
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

    @Test
    @DisplayName("틀린 후 게임을 다시 시작했을 때 제대로 결과가 나오는 지 확인한다.")
    void retryAfterWrongAnswerTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("다시 시작과 종료를 모두 했을 때 제대로 결과가 나오는 지 확인한다.")
    void retryAndQuitAfterWrongAnswerTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "D", "R", "D", "Q");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );
            int upSideIndex = output().indexOf("[   ]");
            int downSideIndex = output().indexOf("[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
