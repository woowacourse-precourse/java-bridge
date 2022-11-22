package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.GameResult;
import bridge.domain.Step;
import bridge.dto.GameResultDto;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    private GameResult gameResult;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        initGameResult();
    }

    private void initGameResult() {
        gameResult = new GameResult();
        gameResult.addResult(Step.UP, true);
        gameResult.addResult(Step.DOWN, true);
        gameResult.addResult(Step.DOWN, true);
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @DisplayName("게임 중간 결과 정상 출력 테스트")
    @Test
    void printValidGameResultTest() {
        GameResultDto gameResultDto = new GameResultDto(gameResult);
        OutputView outputView = new OutputView();
        outputView.printMap(gameResultDto);

        assertThat(output()).contains(
                "[ O |   |   ]",
                "[   | O | O ]"
        );
    }

    @DisplayName("게임 실패 최종 결과 정상 출력 테스트")
    @Test
    void printFinalGameFailResultTest() {
        gameResult.addResult(Step.UP, false);
        GameResultDto gameResultDto = new GameResultDto(gameResult);
        OutputView outputView = new OutputView();
        outputView.printResult(gameResultDto);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   | X ]",
                "[   | O | O |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
        );
    }

    @DisplayName("게임 성공 최종 결과 정상 출력 테스트")
    @Test
    void printValidGameSuccessTest() {
        gameResult.setGameSuccess();
        GameResultDto gameResultDto = new GameResultDto(gameResult);
        OutputView outputView = new OutputView();
        outputView.printResult(gameResultDto);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }
}
