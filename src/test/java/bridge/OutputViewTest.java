package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class OutputViewTest {
    private static final OutputView outputView = new OutputView();

    @Test
    @DisplayName("이동 결과 출력문 테스트")
    void printMap() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printMap(List.of("O", " ", "X"));
        assertThat(outputStream.toString()).contains("[ O |   | X ]");
    }

    @Test
    @DisplayName("게임 결과 출력문 테스트")
    void printResult() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.printResult("성공", 3);
        assertThat(outputStream.toString()).contains(
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3");
    }
    
}