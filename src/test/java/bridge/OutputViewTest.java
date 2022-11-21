package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void init() {
        outputView = new OutputView();
    }

    @DisplayName("예제의 입력 테스트1")
    @Test
    void 예제_출력_테스트1() {
        final String output = "[ O |   |   ]\n[   | O | O ]\n";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> bridgeState = Arrays.asList("U", "D", "D");
        List<String> moveState = Arrays.asList("U", "D", "D");
        outputView.printMap(bridgeState, moveState);
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("예제의 입력 테스트2")
    @Test
    void 예제_출력_테스트2() {
        final String output = "[ O |   |   | O | O | O |   | X ]\n[   | O | O |   |   |   | O |   ]\n";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> bridgeState = Arrays.asList("U", "D", "D", "U", "U", "U", "D", "D");
        List<String> moveState = Arrays.asList("U", "D", "D", "U", "U", "U", "D", "U");
        outputView.printMap(bridgeState, moveState);
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("중간에 틀린 값이 있을 경우 테스트")
    @Test
    void 비정상_상태_테스트() {
        List<String> bridgeState = Arrays.asList("U", "D", "D");
        List<String> moveState = Arrays.asList("D", "D", "D");
        assertThatThrownBy(() -> outputView.printMap(bridgeState, moveState))
                .isInstanceOf(IllegalStateException.class);
    }
}