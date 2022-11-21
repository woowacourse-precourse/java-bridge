package bridge;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
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

    @DisplayName("게임 재시도 여부가 'R'나 'Q'가 아닐 경우 예외 처리한다. (Case 1)")
    @Test
    void invalidRetryCommandCase1() {
        InputStream in = mockUserInput("3");
        System.setIn(in);

        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시도 여부가 'R'나 'Q'가 아닐 경우 예외 처리한다. (Case 2)")
    @Test
    void invalidRetryCase2() {
        InputStream in = mockUserInput("X");
        System.setIn(in);

        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시도 여부가 'R'나 'Q'가 아닐 경우 예외 처리한다. (Case 3)")
    @Test
    void invalidRetryCase3() {
        InputStream in = mockUserInput("q");
        System.setIn(in);

        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static InputStream mockUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
