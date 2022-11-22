package bridge;

import bridge.view.OutputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    void 이동_로그_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        char[][] map = {{'O', 'O', 'O', ' '}, {' ', ' ', ' ', 'X'}};
        outputView.printMap(map);

        String output = out.toString();
        assertThat(output).contains("[ O | O | O |   ]",
                "[   |   |   | X ]"
        );
    }

    @Test
    void 게임_결과_출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.log = new char[][] {{'O', 'O', 'O'}, {' ', ' ', ' ',}};
        bridgeGame.survival = true;
        outputView.printResult(3,bridgeGame);
        String output = out.toString();
        assertThat(output).contains(
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
        );

    }
}