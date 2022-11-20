package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Validation;
import view.InputView;
import view.OutputView;

class BridgeGameTest extends NsTest {
    @Test
    void 끝까지_건넜을때_게임종료문구_이동한결과_출력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
