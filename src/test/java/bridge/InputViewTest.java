package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    protected final void init() {
        inputView = new InputView();
    }

    @DisplayName("다리 길이는 숫자로 입력 되지 않으면 예외가 발생한다.")
    @Test
    void readBridgeSizeByNotNumeric() {
        assertThatThrownBy(() -> {
            command("a", "", " ");
            inputView.readBridgeSize();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("다리 길이는 3부터 20사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void readBridgeSizeByInCorrectRange() {
        assertThatThrownBy(() -> {
            command("1", "-1", "21");
            inputView.readBridgeSize();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("이동할 칸은 U나 D가 아니면 예외가 발생한다.")
    @Test
    void readMovingByInCorrectPos() {
        assertThatThrownBy(() -> {
            command("1", "F", "UU");
            inputView.readMoving();
        }).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("명령은 R이나 Q가 아니면 예외가 발생한다.")
    @Test
    void readGameCommandByInCorrectCommand() {
        assertThatThrownBy(() -> {
            command("1", "F", "RR");
            inputView.readGameCommand();
        }).isInstanceOf(NoSuchElementException.class);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
