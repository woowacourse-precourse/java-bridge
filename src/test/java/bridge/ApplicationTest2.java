package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest2 extends NsTest {

    @Test
    @DisplayName("실패 후 재시도")
    void retry_test(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U","R","U", "D","D");
            assertThat(output()).contains(
                "[ O |   | X ]",
                "[   | O |   ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

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
    @DisplayName("실패 후 종료")
    void quit_test(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U","Q");
            assertThat(output()).contains(
                "[ O |   | X ]",
                "[   | O |   ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

                "최종 게임 결과",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | X ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
