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
        assertThatThrownBy(() -> outputView.printMap(bridgeState, moveState)).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("게임이 성공한 경우 출력 테스트")
    @Test
    void 성공한_경우_테스트() {
        final List<String> bridge = Arrays.asList("U", "U", "D");
        final List<String> move = Arrays.asList("U", "U", "D");
        final int count = 3;
        String result = "게임 성공 여부: 성공\n총 시도한 횟수: " + count + "\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView.printResult(bridge, move, count);
        assertThat(outputStream.toString()).isEqualTo(result);
    }

    @DisplayName("게임이 실패한 경우 출력 테스트")
    @Test
    void 실패한_경우_테스트() {
        final List<String> bridge = Arrays.asList("U", "U", "D");
        final List<String> move = Arrays.asList("U", "U", "U");
        final int count = 3;
        String result = "게임 성공 여부: 실패\n총 시도한 횟수: " + count + "\n";

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputView.printResult(bridge, move, count);
        assertThat(outputStream.toString()).isEqualTo(result);
    }
}