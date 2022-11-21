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
    private static OutputView outputView;
    private static OutputStream out;

    @BeforeEach
    void beforeEach() {
        outputView = new OutputView();
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
}
