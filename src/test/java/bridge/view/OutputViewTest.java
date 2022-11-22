package bridge.view;

import static bridge.result.GameResult.FAIL;
import static bridge.result.GameResult.PROGRESS;
import static bridge.result.GameResult.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.result.Result;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private OutputStream out;

    @BeforeEach
    void init() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("진행 중인 게임 다리 출력 테스트")
    @Test
    void printProgressGameBridge() {
        OutputView outputView = new OutputView();
        outputView.printMap(new Result(List.of("U", "D", "U", "U"), PROGRESS));
        int upSideIndex = getIndex("[ O |   | O | O ]");
        int downSideIndex = getIndex("[   | O |   |   ]");

        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("게임 실패한 다리 출력 테스트")
    @Test
    void printFailGameBridge() {
        OutputView outputView = new OutputView();
        outputView.printMap(new Result(List.of("U", "D", "U", "D"), FAIL));
        int upSideIndex = getIndex("[ O |   | O |   ]");
        int downSideIndex = getIndex("[   | O |   | X ]");

        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    @DisplayName("게임을 클리어한 다리 출력 테스트")
    @Test
    void printSuccessGameBridge() {
        OutputView outputView = new OutputView();
        outputView.printMap(new Result(List.of("D", "U", "U", "D"), SUCCESS));
        int upSideIndex = getIndex("[   | O | O |   ]");
        int downSideIndex = getIndex("[ O |   |   | O ]");

        assertThat(upSideIndex).isLessThan(downSideIndex);
    }

    private Integer getIndex(String output) {
        return out.toString().indexOf(output);
    }
}
