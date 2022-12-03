package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest extends NsTest {

    @DisplayName("게임을 시작한 후 틀리고 종료시킨다.")
    @Test
    void gameTestByFailMoving() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            Assertions.assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }

    @DisplayName("게임을 시작한 후 틀리고 재시작하여 성공시킨다. 이때 증가된 시도 횟수를 파악한다.")
    @Test
    void gameTestByFailMovingAndRetry() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "U", "D", "U");
            Assertions.assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
