package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {

    OutputView outputView;
    OutputStream output;

    @BeforeEach()
    void setup() {
        outputView = new OutputView(Arrays.asList("U", "U", "U"));
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("printNowMap 성공 테스트")
    void printMap1() {
        outputView.printMap(1, true, "U");
        assertThat(output.toString()).isEqualTo("[ O ]\n[   ]\n");
    }

    @Test
    @DisplayName("printNowMap 실패 테스트")
    void printMap2() {
        outputView.printMap(1, false, "U");
        assertThat(output.toString()).isEqualTo("[ X ]\n[   ]\n");
    }

    @Test
    @DisplayName("printPreMap 테스트")
    void printMap3() {
        outputView.printMap(2, true, "U");
        assertThat(output.toString()).isEqualTo("[ O | O ]\n[   |   ]\n");
    }

    @Test
    @DisplayName("printResult 성공 테스트")
    void printResult1() {
        outputView.printResult(true, 0);
        assertThat(output.toString()).contains("성공",
                "1");
    }

    @Test
    @DisplayName("printResult 실패 테스트")
    void printResult2() {
        outputView.printResult(false, 0);
        assertThat(output.toString()).contains("실패",
                "0");
    }

}