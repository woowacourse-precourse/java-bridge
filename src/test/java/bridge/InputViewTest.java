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


}