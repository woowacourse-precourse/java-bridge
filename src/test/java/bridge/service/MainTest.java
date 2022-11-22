package bridge.service;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class MainTest extends NsTest {

    @Test
    @DisplayName("통합 테스트, 성공 여부 : 성공")
    void integrateSuccessTest() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "D", "R", "U", "D", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | O ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
