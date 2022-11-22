package bridge.view;

import bridge.domain.GameStatus;
import bridge.domain.Bridge;
import bridge.domain.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private static OutputView outputView;
    private static OutputStream consoleOut;


    @BeforeEach
    void init() {
        outputView = new OutputView();
        consoleOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOut));

    }

    @Test
    void 최종_결과_성공_출력_테스트() {
        GameStatus gameStatus = new GameStatus();
        outputView.printResult(gameStatus, GameResult.success(new Bridge(List.of("U", "D", "U", "D"))));
        String printOut = consoleOut.toString().trim();

        assertThat(printOut).contains(
                "최종 게임 결과",
                "[ O |   | O |   ]",
                "[   | O |   | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }

    @Test
    void 최종_결과_실패_출력_테스트() {
        GameStatus gameStatus = new GameStatus();
        outputView.printResult(gameStatus, GameResult.fail(new Bridge(List.of("U", "D", "U", "D"))));
        String printOut = consoleOut.toString().trim();

        assertThat(printOut).contains(
                "최종 게임 결과",
                "[ O |   | O |   ]",
                "[   | O |   | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
        );
    }
}
