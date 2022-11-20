package bridge;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @DisplayName("다리 길이 입력 시 숫자가 아닌 경우 예외처리 한다.")
    @Test
    void bridgeSizeNotNumeric() {
        InputStream in = mockUserInput("NonNumeric");
        System.setIn(in);

        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 시 숫자인 경우 정상적으로 변환한다.")
    @Test
    void bridgeSizeNumeric() {
        InputStream in = mockUserInput("3");
        System.setIn(in);

        InputView inputView = new InputView();
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    private static InputStream mockUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
