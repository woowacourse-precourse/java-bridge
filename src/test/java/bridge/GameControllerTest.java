package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest extends NsTest {
    @Test
    @DisplayName("재시작_확인")
    void restartTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("실패시_종료_확인")
    void quitTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

        }, 1, 0, 1);
    }

    @Test
    @DisplayName("실패시_종료_확인2")
    void quitTest2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

        }, 1, 0, 1);
    }

    @Override
    @BeforeEach
    protected void runMain() {
        Application.main(new String[]{});
    }

}
