package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest extends NsTest {

    @Test
    void 기능_테스트_2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O |   ]",
                    "[ O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[   | O |   ]");
            int downSideIndex = output().indexOf("[ O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 0);
    }

    @Test
    void 기능_테스트_3() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "R", "D", "D", "R", "D", "U", "U", "R", "D", "U", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O |   ]",
                    "[ O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );
        }, 0, 1, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
