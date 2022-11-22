package controller;

import bridge.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ControllerTest extends NsTest {

    @Test
    void 컨트롤러_게임_진행_테스트() {

        assertRandomNumberInRangeTest(() -> {
            System.out.println();
            run("5", "U", "U", "U", "D", "D");
            assertThat(output()).contains(
                    "[ O | O | O |   |   ]",
                    "[   |   |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 1, 0, 0);
    }

    @Test
    void 컨트롤러_틀린_다리_출력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("5", "U", "U", "U", "D", "D", "Q");
        }, 1, 1, 1, 0, 1);
    }

    @Test
    void 컨트롤러_재시도_예외_처리_후_반복_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("5", "U", "U", "U", "D", "D", "l", "R");
        }, 0, 1, 1, 0, 1);
    }

    @Test
    void 컨트롤러_재시도_예외_처리_후_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("5", "U", "U", "U", "D", "D", "l", "Q");
        }, 0, 1, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Controller controller = new Controller(new OutputView(), new InputView());
        controller.startGame(new BridgeGame());
    }
}