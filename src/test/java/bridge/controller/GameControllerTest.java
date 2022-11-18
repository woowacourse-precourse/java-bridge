package bridge.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameControllerTest extends NsTest {

    BridgeGameController gameController = new BridgeGameController();

    @DisplayName("U, D, U, U, U 다리")
    @Test
    void controllerTest() {
        gameController.setBridge(List.of("U", "D", "U", "U", "U"));
        run("U", "D", "U", "U", "U");

        Assertions.assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O | O | O ]",
                "[   | O |   |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }

    @DisplayName("U, D, D")
    @Test
    void controllerTryTwoTest() {
        gameController.setBridge(List.of("U", "D", "D"));
        run("U", "U", "R", "U", "D", "D");

        Assertions.assertThat(output()).contains(
                "[ O | X ]",
                "[   |   ]",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
        );
    }

    @DisplayName("U, D, U")
    @Test
    void controllerFailTest() {
        gameController.setBridge(List.of("U", "D", "U"));
        run("U", "U", "Q");

        Assertions.assertThat(output()).contains(
                "최종 게임 결과",
                "[ O | X ]",
                "[   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
        );
    }

    @Override
    public void runMain() {
        gameController.start();

    }
}
