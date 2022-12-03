package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class OutputViewTest {
    @Test
    @DisplayName("다리 필터 테스트")
    void 필터_출력_테스트() {
        List<String> bridge = List.of("U", "D", "D");
        String decode = new String("13");
        String compareText ="[ O |   |   |   ]\n[   | O | O | X ]";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new OutputView().printMap(bridge,"D",false);
        assertThat(out.toString().trim()).isEqualTo(convertLFToCRLF(compareText));
    }

    private String  convertLFToCRLF (String str) {
        StringBuilder convert = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\n' && str.charAt(i - 1) != '\r') {
                convert.append('\r');
            }
            convert.append(str.charAt(i));
        }
        return convert.toString();
    }

}
