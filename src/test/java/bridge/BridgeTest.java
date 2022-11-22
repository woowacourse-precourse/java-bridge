package bridge;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest extends NsTest {

    @Test
    void 재시작_실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "R", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0);
    }

    @Test
    void 재시작_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "D", "R", "U", "D", "D", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   |   | O ]",
                    "[   | O | O | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 0, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});

    }
}
