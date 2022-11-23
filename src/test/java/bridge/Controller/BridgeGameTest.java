package bridge.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init(){
        bridgeGame = new BridgeGame();
    }

    @Test
    void run() {
    }

    @DisplayName("다리 사이즈 입력이 정상일 때까지 입력을 다시 받아야 한다.")
    @Test
    void makeBridge() {
        String input = "a\n1\n25\n3\n";
        String output = "다리의 길이를 입력해주세요.\r\n" +
                "[ERROR] 다리 길이는 숫자여야 합니다.\r\n" +
                "다리의 길이를 입력해주세요.\r\n" +
                "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\r\n" +
                "다리의 길이를 입력해주세요.\r\n" +
                "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\r\n" +
                "다리의 길이를 입력해주세요.\r\n" +
                "\r\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        bridgeGame.makeBridge();
        assertThat(out.toString()).isEqualTo(output);
    }

    @Test
    void crossBridge() {

    }

    @DisplayName("이동 입력이 정상일 때까지 입력을 다시 받아야 한다.")
    @Test
    void move() {
        String input = "3\na\n1\nu\nU\n";
        String output = "다리의 길이를 입력해주세요.\r\n" +
                "\r\n" +
                "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n" +
                "[ERROR] 이동할 칸은 U 또는 D여야 합니다.\r\n" +
                "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n" +
                "[ERROR] 이동할 칸은 U 또는 D여야 합니다.\r\n" +
                "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n" +
                "[ERROR] 이동할 칸은 U 또는 D여야 합니다.\r\n" +
                "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        bridgeGame.makeBridge();
        bridgeGame.move();
        assertThat(out.toString()).contains(output);
    }

    @DisplayName("재시작 여부 입력이 정상일 때까지 입력을 다시 받아야 한다.")
    @Test
    void selectRetry() {
        String input = "3\na\nq\nQ";
        String output = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\r\n" +
                "[ERROR] 재시도 여부는 R 또는 Q여야 합니다.\r\n" +
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\r\n" +
                "[ERROR] 재시도 여부는 R 또는 Q여야 합니다.\r\n" +
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\r\n" +
                "[ERROR] 재시도 여부는 R 또는 Q여야 합니다.\r\n" +
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\r\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        bridgeGame.selectRetry();
        assertThat(out.toString()).isEqualTo(output);
    }

    @Test
    void retry() {
    }

    @Test
    void showResult() {
    }
}