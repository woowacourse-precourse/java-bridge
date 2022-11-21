package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @Test
    @DisplayName("BridgeSize 입력 성공")
    void case1() {
        InputView input = new InputView();

        String userInput = "4";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        int result = input.readBridgeSize();

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("Bridge 입력 실패: 숫자가 아닌경우")
    void case2() {
        InputView input = new InputView();

        String userInput = "AAA";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertThatThrownBy(input::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("moving 입력 성공")
    void case3() {
        InputView input = new InputView();

        String userInput = "U";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        String result = input.readMoving();

        assertThat(result).isEqualTo(userInput);
    }

    @Test
    @DisplayName("moving 입력 실패: [A-Z]사이의 입력이 아닌경우")
    void case4() {
        InputView input = new InputView();

        String userInput = "123";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readMoving).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("GameCommand 입력 성공")
    void case5() {
        InputView input = new InputView();

        String userInput = "R";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        String result = input.readGameCommand();

        assertThat(result).isEqualTo("R");
    }

    @Test
    @DisplayName("GameCommand 입력 실패 : [A-Z] 사이의 입력이 아닌 경우")
    void case6() {
        InputView input = new InputView();

        String userInput = "a";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertThatThrownBy(input::readGameCommand).isInstanceOf(IllegalArgumentException.class);
    }
}
