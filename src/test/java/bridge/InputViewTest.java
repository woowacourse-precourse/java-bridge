package bridge;

import bridge.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @ValueSource(strings = {"12a", "123", "abc"})
    @ParameterizedTest
    void 다리길이_입력값_유효성_검사(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"123", "DU", "DD", "ABCabc"})
    @ParameterizedTest
    void 다리선택_입력값_유효섬_검사(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"W", "AB", "123", "A11abc"})
    @ParameterizedTest
    void 재시도_입력값_유효성_검사(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(inputView::readGameCommand).isInstanceOf(IllegalArgumentException.class);
    }
}
