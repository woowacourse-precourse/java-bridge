package bridge.view;

import bridge.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @Test
    void printMapTest() {
        assertSimpleTest(() -> {
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D", "U"));
            run(bridgeGame);
            new OutputView().printMap(bridgeGame.upBridge, bridgeGame.downBridge);
            assertThat(output()).contains(
                    "[ O |   | X ]",
                    "[   | O |   ]"
            );
        });
    }

    @Test
    void printResultTest() {
        assertSimpleTest(() -> {
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D", "U"));
            run(bridgeGame);
            new OutputView().printResult(bridgeGame, 3);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | X ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );
        });
    }
    protected void run(BridgeGame bridgeGame) {
        List<String> player = List.of("U", "D", "U");
        List<String> upBridge = List.of("O", " ", "X");
        List<String> downBridge = List.of(" ", "O", " ");
        bridgeGame.player= player;
        bridgeGame.upBridge = upBridge;
        bridgeGame.downBridge = downBridge;
    }

    @Override
    protected void runMain() {

    }
}