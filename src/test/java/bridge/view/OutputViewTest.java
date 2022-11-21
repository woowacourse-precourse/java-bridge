package bridge.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private OutputView outputView;
    private PrintStream standardOut;
    private ByteArrayOutputStream captor;

    @BeforeEach
    public void setUp() {
        outputView = new OutputView();
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    private String output() {
        return captor.toString().trim();
    }

    @DisplayName("다리 건너기 게임 시작을 출력")
    @Test
    void printWelcome() {
        outputView.printWelcome();
        assertThat(output()).contains("다리 건너기 게임을 시작합니다.");
    }

    @Test
    void printMap() {
        outputView.printMap(List.of(List.of("O", " ", " "), List.of(" ", "O", "X")));
        assertThat(output()).contains("[ O |   |   ]").contains("[   | O | X ]");
    }

//    @DisplayName("최종 게임 결과를 출력")
//    @Test
//    void printResult() {
//        outputView.printResult(true, 10);
//        assertThat(output()).contains("게임 성공 여부: 성공").contains("총 시도한 횟수: 10");
//    }
}