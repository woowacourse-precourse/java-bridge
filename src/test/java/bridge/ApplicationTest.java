package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @DisplayName("다리 사이즈가 3이고, 아래, 위, 아래 순으로 이동했을 때 성공한 경우")
    @Test
    void enterBridgeSize3AndMovementDUDBySuccessful() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "D");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   | O |   ]",
                "[ O |   | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );
        }, 0, 1, 0);
    }

    @DisplayName("다리 사이즈가 4이고, 아래, 위, 아래 순으로 이동하다가 실패하여 게임을 그만하는 경우")
    @Test
    void enterBridgeSize4AndMovementUDUAlsoNotRetry() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O |   ]",
                    "[ O |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 0, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
