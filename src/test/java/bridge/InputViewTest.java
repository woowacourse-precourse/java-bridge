package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void init(){
        inputView = new InputView();
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외 발생")
    @Test
    void 잘못된_다리_입력(){
        String input = "a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3-20 사이가 아닌 값을 입력하면 예외 발생")
    @Test
    void 잘못된_다리_사이즈_입력(){
        String input = "200";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 값을 입력하는 경우 정상 통과")
    @Test
    void 정상_다리_사이즈_입력(){
        String input = "10";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertDoesNotThrow(() -> inputView.readBridgeSize());
    }
}