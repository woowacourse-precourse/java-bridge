package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    private GameController gameController;
    private OutputStream out;

    @BeforeEach
    void init_Test() {
        gameController = new GameController(new InputView(), new OutputView());
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("입력된 값에 대응하는 올바른 메세지가 출력된다.")
    void start_IsGameMessageContainsExpectedMessage_True() {
        System.setIn(new ByteArrayInputStream((
                "21\n" + "3\n" + "U\n" + "u\n" + "U\n" + "0\n" + "R\n" + "D\n" + "U\n").getBytes()));
        gameController.start(new BridgeStaticNumberGenerator());
        assertThat(out.toString()).contains(
                "[ERROR] 3 이상 20 이하의 자연수를 입력하세요.",
                "[ERROR] U 또는 D를 입력하세요.",
                "[ERROR] R 또는 Q를 입력하세요.",
                "[ O | X ]",
                "[   |   ]",
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
        );
    }

    private class BridgeStaticNumberGenerator implements BridgeNumberGenerator {
        int count = 0;

        @Override
        public int generate() {
            if (count++ % 2 == 0) {
                return 1;
            }
            return 0;
        }
    }
}