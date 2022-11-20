package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

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
    private static List<String> bridge;
    private static int order;

    @BeforeEach
    void beforeEach() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        bridge = List.of("U", "D", "U", "D");
        order = 3;
    }

    @DisplayName("유저가 특정 칸에 대한 다리 건너기를 성공 했을 때 결과를 출력한다.")
    @Test
    void printMapWhenUserSucceed() {
        outputView.printMap(bridge, order, false);
        assertThat(out.toString())
                .contains(
                        "[ O |   | O ]",
                        "[   | O |   ]"
                );
    }

    @DisplayName("유저가 특정 칸에 대한 다리 건너기를 실패 했을 때 결과를 출력한다.")
    @Test
    void printMapWhenUserFail() {
        outputView.printMap(bridge, order, true);
        assertThat(out.toString())
                .contains(
                        "[ O |   |   ]",
                        "[   | O | X ]"
                );
    }

}
