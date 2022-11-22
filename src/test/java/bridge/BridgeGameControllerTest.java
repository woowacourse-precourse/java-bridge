package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameControllerTest extends NsTest {
    BridgeGame bridgeGame;
    List<String> answerBridge;

    @Test
    @DisplayName("틀린 후 게임을 종료한다.")
    void quitGameTest() {
        answerBridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(answerBridge);
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]"
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("틀린 후 게임을 재시작한다.")
    void restartGameTest() {
        answerBridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(answerBridge);
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("끝까지 완주한다.")
    void endGameTest() {
        answerBridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(answerBridge);
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
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