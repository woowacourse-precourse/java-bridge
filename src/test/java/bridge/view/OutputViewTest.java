package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.service.constant.ChoiceResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class OutputViewTest {
    private static final OutputView outputView = OutputView.getInstance();
    private static OutputStream out;

    @BeforeEach
    void beforeEach() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("gameLog를 받았을 때 스타일을 입혀 주어진 형식에 맞게 출력한다.")
    @Test
    void printMapWhenUserSucceed() {
        List<List<ChoiceResult>> gameLog = List.of(
                List.of(ChoiceResult.CORRECT, ChoiceResult.NOT_CHOSEN, ChoiceResult.NOT_CHOSEN),
                List.of(ChoiceResult.NOT_CHOSEN, ChoiceResult.CORRECT, ChoiceResult.WRONG)
        );
        outputView.printMap(gameLog);
        assertThat(out.toString())
                .contains(
                        "[ O |   |   ]",
                        "[   | O | X ]"
                );
    }

    @DisplayName("게임 성공 시 성공 결과를 출력한다.")
    @Test
    void When_UserClearGame_Expect_SuccessResultDisplay() {
        List<List<ChoiceResult>> gameLog = List.of(
                List.of(ChoiceResult.CORRECT, ChoiceResult.NOT_CHOSEN, ChoiceResult.CORRECT),
                List.of(ChoiceResult.NOT_CHOSEN, ChoiceResult.CORRECT, ChoiceResult.NOT_CHOSEN)
        );
        outputView.printResult(gameLog, true, 3);
        assertThat(out.toString())
                .contains(
                        "최종 게임 결과",
                        "[ O |   | O ]",
                        "[   | O |   ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 3"
                );
    }

    @DisplayName("게임 실패 시 실패 결과를 출력한다.")
    @Test
    void When_UserDidNotClearGame_Expect_FailResultDisplay() {
        List<List<ChoiceResult>> gameLog = List.of(
                List.of(ChoiceResult.CORRECT, ChoiceResult.NOT_CHOSEN, ChoiceResult.NOT_CHOSEN),
                List.of(ChoiceResult.NOT_CHOSEN, ChoiceResult.CORRECT, ChoiceResult.WRONG)
        );
        outputView.printResult(gameLog, false, 5);
        assertThat(out.toString())
                .contains(
                        "최종 게임 결과",
                        "[ O |   |   ]",
                        "[   | O | X ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 5"
                );
    }
}
