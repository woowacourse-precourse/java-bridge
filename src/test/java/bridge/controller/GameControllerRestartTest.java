package bridge.controller;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerRestartTest extends NsTest {

    private GameController gameController = new GameController();

    @DisplayName("중간에 이동입력시 잘못된 값을 입력해도 결과가 제대로 출력된다.")
    @Test
    void 이동_예외_입력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "U", "X", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O |   |   ]",
                    "[   |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 0, 0);
    }

    @DisplayName("게임을 실패후 그만두면 게임 성공여부에 실패가 표시된다.")
    @Test
    void 게임_실패_입력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   ]",
                    "[   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 1, 0, 0);
    }

    @DisplayName("게임을 실패후 재시작시 성공여부에 실패가 표시된다.")
    @Test
    void 게임_재시작_입력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "R", "U", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O |   |   ]",
                    "[   |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 1, 0, 0);
    }
    protected void runMain() {
        Application.main(new String[]{});
    }
}
