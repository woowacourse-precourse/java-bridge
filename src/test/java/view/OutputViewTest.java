package view;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

class OutputViewTest {
    private OutputView outputView;
    private OutputStream out;
    private InputStream in;

    private String greetingMsg = "다리 건너기 게임을 시작합니다.";
    private String gameResultMsg = "최종 게임 결과";
    private String gameSucceedMsg = "게임 성공 여부: ";
    private String totalTriesMsg = "총 시도한 횟수: ";


    @BeforeEach
    void beforeEach(){
        this.outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void printMap() {
        List<String> ups = List.of(" ", "X");
        List<String> downs = List.of("O", " ");
        outputView.printMap(ups, downs);

        assertThat(out.toString())
                .contains(
                        "[   | X ]",
                        "[ O |   ]"
                );
    }

    @Test
    void printOneMap() {
        List<String> oneMap = List.of("1", "2", "a", "B");
        outputView.printOneMap(oneMap);
        assertThat(out.toString().trim())
                .contains("[ 1 | 2 | a | B ]".trim());
    }

    @Test
    void printResult() {
        List<String> ups = List.of(" ", "X");
        List<String> downs = List.of("O", " ");
        outputView.printResult(ups, downs, "실패", 1);
        assertThat(out.toString())
                .contains(
                        "최종 게임 결과",
                        "[   | X ]",
                        "[ O |   ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 1"
                );
    }

    @Test
    void printGreeting() {
        outputView.printGreeting();
        assertThat(out.toString().trim())
                .contains(greetingMsg.trim());
    }

}