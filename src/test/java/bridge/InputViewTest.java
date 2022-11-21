package bridge;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @DisplayName("정수가 아닌 데이터를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest1() {
        InputView inputView = new InputView();

        String input = "3.14";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수가 아닌 데이터를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest2() {
        InputView inputView = new InputView();

        String input = "안녕!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3보다 작은 숫자를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest3() {
        InputView inputView = new InputView();

        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20보다 큰 숫자를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest4() {
        InputView inputView = new InputView();

        String input = "23";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 데이터가 U나 D가 아닌 경우 예외가 발생한다.")
    @Test
    void readMovingTest1() {
        InputView inputView = new InputView();

        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readMoving()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소문자를 넣어도 대문자로 바꿔준다.")
    @Test
    void readMovingTest2() {
        InputView inputView = new InputView();

        String input = "u";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputView.readMoving()).isEqualTo("1");
    }
}