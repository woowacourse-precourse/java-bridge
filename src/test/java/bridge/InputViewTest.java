package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    @DisplayName("숫자 이외의 값 예외처리 테스트")
    void isNumberTest_Fail() {
        InputView inputView = new InputView();
        command("#");
        assertThatThrownBy(inputView::readInteger).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 이외의 값 예외처리 테스트")
    void isNumberTest_Success() {
        InputView inputView = new InputView();
        command("3");
        assertThat(inputView.readInteger()).isEqualTo(3);
    }
}