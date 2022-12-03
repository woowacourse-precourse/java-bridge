package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView inputView = new InputView();

    @Test
    void 다리사이즈_입력_정상값_테스트() {
        InputStream in = new ByteArrayInputStream("10".getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readBridgeSize()).isEqualTo(10);
    }
    @Test
    void 다리사이즈_입력_예외_테스트() {
        InputStream in = new ByteArrayInputStream("30".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
        in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리이동_입력_테스트() {
        InputStream in = new ByteArrayInputStream("U".getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readMoving()).isEqualTo("U");
        in = new ByteArrayInputStream("D".getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readMoving()).isEqualTo("D");
    }

    @Test
    void 재시작종료_입력_테스트() {
        InputStream in = new ByteArrayInputStream("R".getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readGameCommand()).isEqualTo("R");
        in = new ByteArrayInputStream("Q".getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readGameCommand()).isEqualTo("Q");
    }
}