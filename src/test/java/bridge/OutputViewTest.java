package bridge;

import bridge.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static bridge.Controller.GAME_FAIL;
import static bridge.Controller.GAME_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    private PrintStream standardOut;
    private OutputStream captor;
    private OutputView outputView;

    @BeforeEach
    protected final void init() {
        outputView = new OutputView();
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @DisplayName("현재까지 이동한 다리 상태 출력 테스트")
    @Test
    void printMap() {
        outputView.printMap("U", 0, GAME_SUCCESS);
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
        outputView.printMap("U", 1, GAME_FAIL);
        assertThat(output()).contains(
                "[ O | X ]",
                "[   |   ]"
        );
    }

    @DisplayName("최종 결과 출력 테스트")
    @Test
    void printResult() {
        outputView.printMap("U", 0, GAME_SUCCESS);
        outputView.printMap("U", 1, GAME_FAIL);
        outputView.printResult(GAME_FAIL, 2);
        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O | X ]",
                "[   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2"
        );
    }
}
