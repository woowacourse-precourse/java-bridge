package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class InputViewTest {

    void stdInput(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void 다리_개수_입력_테스트1() {
        InputView input = new InputView();
        this.stdInput("10");
        assertThat(input.readBridgeSize()).isEqualTo(10);
    }

    @Test
    void 다리_개수_입력_테스트2() {
        InputView input = new InputView();
        this.stdInput("21");

        assertThatThrownBy(() -> input.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_개수_입력_테스트3() {
        InputView input = new InputView();
        this.stdInput("2");

        assertThatThrownBy(() -> input.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_칸_입력_테스트1() {
        InputView input = new InputView();
        this.stdInput("D");
        assertThat(input.readMoving()).isEqualTo(0);
    }

    @Test
    void 이동_칸_입력_테스트2() {
        InputView input = new InputView();
        this.stdInput("U");
        assertThat(input.readMoving()).isEqualTo(1);
    }

    @Test
    void 이동_칸_입력_테스트3() {
        InputView input = new InputView();
        this.stdInput("K");

        assertThatThrownBy(() -> input.readMoving()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시도_입력_테스트1() {
        InputView input = new InputView();
        this.stdInput("R");
        assertThat(input.readGameCommand()).isEqualTo(true);
    }

    @Test
    void 재시도_입력_테스트2() {
        InputView input = new InputView();
        this.stdInput("Q");
        assertThat(input.readGameCommand()).isEqualTo(false);
    }

    @Test
    void 재시도_입력_테스트3() {
        InputView input = new InputView();
        this.stdInput("E");

        assertThatThrownBy(() -> input.readGameCommand()).isInstanceOf(IllegalArgumentException.class);
    }
}
