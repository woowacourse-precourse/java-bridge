package bridge.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static InputView inputView;

    @BeforeEach
    private void setUp() {
        inputView = new InputView();
    }

    @Test
    void 다리크기입력_예외테스트() {
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"X", "u", "UU", "Q"})
    void 음직임_입력_예외테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readMoving()).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"r", "q", "QQ", "U"})
    void 재시작_입력_예외테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readGameCommand()).isInstanceOf(IllegalArgumentException.class);
    }
}