package bridge;

import bridge.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class InputViewTest {

    private static final InputView inputView = new InputView();

    @DisplayName("다리 사이즈를 입력받아서 반환")
    @Test
    void inputBridgeSize() {
        InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        Assertions.assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }
}