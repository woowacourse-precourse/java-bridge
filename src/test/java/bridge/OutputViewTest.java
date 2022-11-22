package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.output.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    OutputView outputView = new OutputView();
    OutputStream out;
    @BeforeEach
    void setup(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("UDD로 이루어진 다리를 성공적으로 통과한 경우")
    @Test
    void bridgeUDDSuccess() {
        List<String> answerBridge = List.of("U", "D", "D");
        List<String> bridgeTrack = List.of("U", "D", "D");

        outputView.printMap(bridgeTrack, answerBridge);
        assertThat(out.toString()).isEqualTo(""
                + "[ O |   |   ]\n"
                + "[   | O | O ]\n\n");
    }
    @DisplayName("UDD로 이루어진 다리를 UU로 실패한 경우")
    @Test
    void bridgeUDDFailByUU() {
        List<String> answerBridge = List.of("U", "D", "D");
        List<String> bridgeTrack = List.of("U", "U");
        outputView.printMap(bridgeTrack, answerBridge);
        assertThat(out.toString()).isEqualTo(
                "[ O | X ]\n"
                + "[   |   ]\n\n");
    }
    @DisplayName("UDD로 이루어진 다리를 2회 시도하여 UDD로 성공한 경우의 결과 출력")
    @Test
    void resultOFBridgeUDDSuccess() {
        List<String> answerBridge = List.of("U", "D", "D");
        List<String> bridgeTrack = List.of("U", "D", "D");
        outputView.printResult(bridgeTrack, answerBridge, 2);
        assertThat(out.toString()).isEqualTo("최종 게임 결과\n"
                + "[ O |   |   ]\n"
                + "[   | O | O ]\n\n"
                + "게임 성공 여부: 성공\n총 시도한 횟수: 2");
    }
    @DisplayName("1회 시도한 UDD로 이루어진 다리를 1회 시도하여 UU로 실패한 경우의 결과 출력")
    @Test
    void resultOFBridgeUDDFailByUU() {
        List<String> answerBridge = List.of("U", "D", "D");
        List<String> bridgeTrack = List.of("U", "U");
        outputView.printResult(bridgeTrack, answerBridge, 1);
        assertThat(out.toString()).isEqualTo(
                "최종 게임 결과\n"
                        + "[ O | X ]\n"
                        + "[   |   ]\n\n"
                        + "게임 성공 여부: 실패\n"
                        + "총 시도한 횟수: 1");
    }

}
