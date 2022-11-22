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
        String[] input = {"100", "five", "10"};
        for (int i = 0; i < input.length; i++) {
            System.setIn(new ByteArrayInputStream(input[i].getBytes()));
        }
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
        String input[] = {"d", "2", "D"};
        for (int i = 0; i < input.length; i++) {
            System.setIn(new ByteArrayInputStream(input[i].getBytes()));
        }
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
        String input[] = {"q", "no", "Q"};
        for (int i = 0; i < input.length; i++) {
            System.setIn(new ByteArrayInputStream(input[i].getBytes()));
        }
        String gameCommand = new InputView().readGameCommand();
        assertThat(gameCommand).isEqualTo("Q");
    }
}