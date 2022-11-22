package bridge.controller;

import camp.nextstep.edu.missionutils.test.NsTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class GameControllerTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    BridgeGameController gameController = new BridgeGameController();

    @BeforeEach
    void setBridge() {
        gameController.setBridge(List.of("U", "D", "D"));
    }

    @DisplayName("칸을 잘못 일렵한 경우 예외 테스트")
    @ValueSource(strings = {"u", "d", "1", ".", "R"})
    @ParameterizedTest
    void wrongInputToMove() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("재시작 여부를 잘못 입력한 경우 예외 테스트")
    @Test
    void wrongInputToRetry() {
        assertSimpleTest(()-> {
            runException("3", "D", "r");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 1시도 성공")
    @Test
    void controllerSuccessByOneTryTest() {

        run("U", "D", "D");

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }

    @DisplayName("다리 2시도 성공")
    @Test
    void controllerSuccessByTwoTryTest() {
        run("U", "U", "R", "U", "D", "D");

        assertThat(output()).contains(
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

    @DisplayName("다리 1시도 실패")
    @Test
    void controllerFailByOneTryTest() {
        run("U", "D", "U", "Q");

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | X ]",
                "[   | O |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
        );
    }

    @Override
    public void runMain() {
        gameController.start();
    }
}
