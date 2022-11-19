package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @DisplayName("UDD로 이루어진 다리를 성공적으로 통과한 경우")
    @Test
    void bridgeUDDSuccess() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> answerBridge = List.of("U", "D", "D");
        List<String> bridgeTrack = List.of("U", "D", "D");

        outputView.printMap(bridgeTrack, answerBridge);
        assertThat(out.toString()).isEqualTo("[ O |   |   ]\n[   | O | O ]");
    }
    @DisplayName("UDD로 이루어진 다리를 UU로 실패한 경우")
    @Test
    void bridgeUDDFailByUU() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        List<String> answerBridge = List.of("U", "D", "D");
        List<String> bridgeTrack = List.of("U", "U");
        outputView.printMap(bridgeTrack, answerBridge);
        assertThat(out.toString()).isEqualTo("[ O | X ]\n[   |   ]");
    }


}
