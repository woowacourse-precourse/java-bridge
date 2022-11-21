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
    @DisplayName("사용자의 입력에 따라 이동한다.")
    void invalidMovingInputTest() {
        answerBridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(answerBridge);
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(bridgeGame.getStatus()).isEqualTo(StatusType.PLAY);
            assertThat(output().contains("[ O |   | O ]"));
        }, 1, 0, 1);
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );

            int upSideIndex = output().indexOf("[ O |  ]");
            int downSideIndex = output().indexOf("[   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}