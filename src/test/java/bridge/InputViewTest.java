package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("다리 사이즈에 비정상적인 입력 테스트")
    void test1() {
        InputView inputView = new InputView();
        System.setIn(generateUserInput("asd"));
        assertThatThrownBy(inputView::readBridgeSize)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("게임을 다시 시작할지 여부로 이상한 입력 테스트")
    void test2() {
        InputView inputView = new InputView();
        System.setIn(generateUserInput("asd"));
        assertThatThrownBy(inputView::readGameCommand)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("위 혹은 아래 외에 비정상적인 입력 테스트")
    void test3() {
        InputView inputView = new InputView();
        System.setIn(generateUserInput("asd"));
        assertThatThrownBy(inputView::readMoving)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("정상적인 재시작여부 테스트")
    void test4() {
        InputView inputView = new InputView();
        System.setIn(generateUserInput("R"));
        String s = inputView.readGameCommand();
        org.junit.jupiter.api.Assertions.assertEquals("R", s);
    }
}
