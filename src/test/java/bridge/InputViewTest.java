package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    void initInputView(){
        inputView = new InputView();
    }

    @Test
    @DisplayName("잘못된 다리 사이즈 입력 예외 테스트")
    void readBridgeSize() {
        String input = "a";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputView.readBridgeSize());
    }

    @Test
    @DisplayName("잘못된 사용자 움직임 입력 테스트")
    void readMoving() {
        String input = "a";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputView.readMoving());
    }

    @Test
    @DisplayName("잘못된 게임 재시작 입력 테스트")
    void readGameCommand() {
        String input = "a";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputView.readGameCommand());
    }
}