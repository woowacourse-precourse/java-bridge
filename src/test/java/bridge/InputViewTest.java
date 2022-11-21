package bridge;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @DisplayName("정수가 아닌 데이터를 입력한 경우 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest1() {
        InputView inputView = new InputView();

        String input = "3.14";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수가 아닌 데이터를 입력한 경우 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest2() {
        InputView inputView = new InputView();

        String input = "안녕!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1보다 작은 숫자를 입력한 경우 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest3() {
        InputView inputView = new InputView();

        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }
}