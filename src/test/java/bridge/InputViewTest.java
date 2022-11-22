package bridge;

import constant.Values.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private InputView inputView = new InputView();

    @DisplayName("잘못된 다리 길이가 입력될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "0", "-1", "a", "1a", "a1", "1 2", " 5", "5 ", " 5 ", "A", "X"})
    void ThrowExceptionIfNotValid_BridgeSize(String input) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readBridgeSize();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_SIZE.getMessage());
    }

    @DisplayName("잘못된 이동 커맨드가 입력될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "0", "-1", "a", "1a", "a1", "1 2", " 5", "5 ", " 5 ", "A", "X"})
    void ThrowExceptionIfNotValid_Move(String input) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readMoving();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_MOVE.getMessage());
    }

    @DisplayName("잘못된 재시도 커맨드가 입력될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "0", "-1", "a", "1a", "a1", "1 2", " 5", "5 ", " 5 ", "A", "X"})
    void ThrowExceptionIfNotValid_GameCommend(String input) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readGameCommand();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_RETRY.getMessage());
    }
}
