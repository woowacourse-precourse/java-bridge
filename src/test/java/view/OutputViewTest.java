package view;

import bridge.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBridgeGenerator.TestBridgeGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest extends NsTest {
    BridgeNumberGenerator bridgeNumberGenerator = new TestBridgeGenerator(List.of(0, 1, 1));
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    GameStatus gameStatus = new GameStatus(false, false);
    BridgeGame bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(3)), gameStatus);

    @DisplayName("사용자가 입력을 하였을 떄 map의 모양을 출력")
    @Test
    void printMap() {
        bridgeGame.move("D");
        bridgeGame.comparedBridge();
        OutputView.printMap(bridgeGame);
        assertThat(output()).contains(
                "[   ]\n" +
                "[ O ]");
        OutputView.printMap(bridgeGame);

        bridgeGame.move("U");
        bridgeGame.comparedBridge();
        OutputView.printMap(bridgeGame);
        assertThat(output()).contains(
                "[   | O ]\n" +
                "[ O |   ]");
        OutputView.printMap(bridgeGame);


        bridgeGame.move("D");
        bridgeGame.comparedBridge();
        OutputView.printMap(bridgeGame);
        assertThat(output()).contains(
                "[   | O |   ]\n" +
                "[ O |   | X ]");
        OutputView.printMap(bridgeGame);
    }

    @DisplayName("사용자가 게임을 종료하거나 성공하였을 때 결과를 출력")
    @Test
    void 사용자가_실패하였지만_종료하였을떄() {
        bridgeGame.move("D");
        bridgeGame.comparedBridge();
        bridgeGame.move("U");
        bridgeGame.comparedBridge();
        bridgeGame.move("D");
        bridgeGame.comparedBridge();

        OutputView.printResult(bridgeGame, gameStatus);
        assertThat(output()).contains(
                "최종 게임 결과",
                "[   | O |   ]",
                "[ O |   | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
        );
    }

    @Test
    void 사용자가_성공하여_종료되었을_떄() {
        bridgeGame.move("D");
        bridgeGame.comparedBridge();
        bridgeGame.move("U");
        bridgeGame.comparedBridge();
        bridgeGame.move("U");
        bridgeGame.comparedBridge();

        OutputView.printResult(bridgeGame, gameStatus);
        assertThat(output()).contains(
                "최종 게임 결과",
                "[   | O | O ]",
                "[ O |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }

    @Override
    protected void runMain() {

    }
}