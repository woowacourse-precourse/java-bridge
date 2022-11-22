package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.OutputView.printMap;
import static bridge.OutputView.printResult;
import static bridge.UpDown.BridgeGameState;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {

    @Test
    @DisplayName("상황에 맞게 잘 출력되는가?")
    void if_success() {
        BridgeGameState("U", "PASS");
        BridgeGameState("D", "PASS");
        BridgeGameState("U", "PASS");
        assertSimpleTest(() -> {
            printMap();
            assertThat(output()).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        });
    }

    @Test
    @DisplayName("상황에 맞게 잘 출력되는가?")
    void if_fail() {
        BridgeGameState("U", "PASS");
        BridgeGameState("D", "FAIL");
        assertSimpleTest(() -> {
            printMap();
            assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | X ]"
            );
        });
    }

    @BeforeEach
    void beforeSet(){
        BridgeGameState("U", "PASS");
        BridgeGameState("D", "PASS");
        BridgeGameState("D", "PASS");
    }

    @Test
    @DisplayName("2번 만에 성공 하였을 때 잘 출력 되는가?")
    void if_end_successfully() {
        String gameState = "성공";
        int count = 2;
        assertSimpleTest(() -> {
            printResult(gameState, count);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
