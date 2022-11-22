package bridge;

import static bridge.InputView.readBridgeSize;
import static bridge.InputView.readGameCommand;
import static bridge.InputView.readMoving;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @DisplayName("정수가 아닌 데이터를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest1() {
        String input = "3.14";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수가 아닌 데이터를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest2() {
        String input = "안녕!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3보다 작은 숫자를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest3() {
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20보다 큰 숫자를 입력한 경우 예외가 발생한다.")
    @Test
    void readBridgeSizeTest4() {
        String input = "23";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 데이터가 U나 D가 아닌 경우 예외가 발생한다.")
    @Test
    void readMovingTest1() {
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> readMoving()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소문자를 넣어도 대문자로 바꿔준다.")
    @Test
    void readMovingTest2() {
        String input = "u";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(readMoving()).isEqualTo("U");
    }

    @DisplayName("입력한 데이터가 R이나 Q가 아닌 경우 예외가 발생한다.")
    @Test
    void readGameCommandTest1() {
        String input = "-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> readGameCommand()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소문자를 넣어도 대문자로 바꿔준다.")
    @Test
    void readGameCommandTest2() {
        String input = "r";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(readGameCommand()).isEqualTo("R");
    }
}