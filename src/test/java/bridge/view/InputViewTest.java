package bridge.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    @Test
    void 다리길이_입력_테스트() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int size = new InputView().readBridgeSize();
        assertThat(size).isEqualTo(5);
    }

    @Test
    void 다리길이_입력_재입력_테스트() {
        String input1 = "100";
        String input2 = "five";
        String input3 = "10";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        InputStream in3 = new ByteArrayInputStream(input3.getBytes());
        System.setIn(in1);
        System.setIn(in2);
        System.setIn(in3);
        int size = new InputView().readBridgeSize();
        assertThat(size).isEqualTo(10);
    }

    @Test
    void 이동할칸_입력_테스트() {
        String input = "U";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String moving = new InputView().readMoving();
        assertThat(moving).isEqualTo("U");
    }

    @Test
    void 이동할칸_입력_재입력_테스트() {
        String input1 = "d";
        String input2 = "2";
        String input3 = "D";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        InputStream in3 = new ByteArrayInputStream(input3.getBytes());
        System.setIn(in1);
        System.setIn(in2);
        System.setIn(in3);
        String moving = new InputView().readMoving();
        assertThat(moving).isEqualTo("D");
    }

    @Test
    void 재시도여부_입력_테스트() {
        String input = "R";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String gameCommand = new InputView().readGameCommand();
        assertThat(gameCommand).isEqualTo("R");
    }

    @Test
    void 재시도여부_입력_재입력_테스트() {
        String input1 = "q";
        String input2 = "no";
        String input3 = "Q";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        InputStream in3 = new ByteArrayInputStream(input3.getBytes());
        System.setIn(in1);
        System.setIn(in2);
        System.setIn(in3);
        String gameCommand = new InputView().readGameCommand();
        assertThat(gameCommand).isEqualTo("Q");
    }
}