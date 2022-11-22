package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameControllerTest extends NsTest {
    @BeforeAll
    static void beforeAll(){
        List<String> answerBridge = List.of("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(answerBridge);
    }
    @Test
    @DisplayName("틀린 후 게임을 종료한다.")
    void quitGameTest() {
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