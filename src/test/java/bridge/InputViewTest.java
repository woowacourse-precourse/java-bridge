package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    @DisplayName("숫자가 아닌 다리 길이 입력에 대한 예외 처리")
    void readNotDigitedBridgeSize(String input) {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "30"})
    @DisplayName("3부터 20사이가 아닌 다리 길이 입력에 대한 예외 처리")
    void readNotInRangedBridgeSize(String input) {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "a", "b", "C", "Z"})
    @DisplayName("U 또는 D가 아닌 이동할 칸 입력에 대한 예외 처리")
    void readInvalidMoving(String input) {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "a", "b", "U", "D"})
    @DisplayName("R 또는 Q가 아닌 다시 시도 여부 입력에 대한 예외 처리")
    void readInvalidGameCommand(String input) {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

}