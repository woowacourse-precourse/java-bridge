package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void run() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "다리의 길이를 입력해주세요.",
                    "이동할 칸을 선택해주세요.",
                    "[   | O |   ]",
                    "최종 게임 결과"
            );
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        GameController controller = new GameController();
        controller.initGame();
        controller.run();
    }
}