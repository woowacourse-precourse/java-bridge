package bridge.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

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
    void 다리길이_입력_예외_테스트1() {
        String input = "100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputView().readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 다리길이_입력_예외_테스트2() {
        String input = "five";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputView().readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }
}