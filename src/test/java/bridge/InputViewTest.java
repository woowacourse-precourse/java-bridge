package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void readBridgeSize() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);

        int bridgeSize = inputView.readBridgeSize();

        assertThat(bridgeSize).isEqualTo(3);
    }

    @Test
    void bridgeSize가_숫자_아닐경우_예외처리() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("e".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

    @Test
    void bridgeSize가_범위를_벗어날경우_예외처리() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }


    @Test
    void readMoving() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("U".getBytes());
        System.setIn(in);

        String moveTo = inputView.readMoving();

        assertThat(moveTo).isEqualTo("U");
    }

    @Test
    void readMoving_입력_예외처리() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("DU".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 한 글자만 입력해주세요.");

        ByteArrayInputStream in2 = new ByteArrayInputStream("X".getBytes());
        System.setIn(in2);

        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] U, D 둘 중 하나만 입력해주세요.");
    }

    @Test
    void readGameCommand() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("R".getBytes());
        System.setIn(in);

        String retryStatus = inputView.readGameCommand();

        assertThat(retryStatus).isEqualTo("R");
    }

    @Test
    void readGameCommand_입력_예외처리() {
        InputView inputView = new InputView();

        ByteArrayInputStream in = new ByteArrayInputStream("RQQ".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 한 글자만 입력해주세요.");

        ByteArrayInputStream in2 = new ByteArrayInputStream("D".getBytes());
        System.setIn(in2);

        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] R, Q 둘 중 하나만 입력해주세요.");
    }
}