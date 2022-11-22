package bridge;

import bridge.controller.GameController;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    GameController gameController = new GameController();

    @AfterEach
    void afterEach(){
        gameController.resetTotalGame();
    }

    @Test
    void 종합_테스트(){
        assertRandomNumberInRangeTest(() -> {
            run( "a", "123", "5", "a", "U", "1", "D", "asd", "D", "r", "R",  "U", "D", "U", "U", "U", "R", "U", "D", "U", "U", "D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "[ O |   | O | O | X ]",
                    "[   | O |   |   |   ]",
                    "[ O |   | O | O |   ]",
                    "[   | O |   |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O | O |   ]");
            int downSideIndex = output().indexOf("[   | O |   |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1,1,0);
    }

    @Test
    void 재시작_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 종료_테스트() {
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
