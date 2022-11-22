package bridge.domain.bridge;

import bridge.exception.BridgeError;
import bridge.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class BridgeSizeTest {

    private InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @DisplayName("다리 길이 예외 테스트")
    @Nested
    class Exception {

        @DisplayName("숫자가 아니라면 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(strings = {"$", "AA", "40 5"})
        void isNotDigit(String size) {
            System.setIn(generateInputStream(size));

            Assertions.assertThatThrownBy(inputView::readBridgeSize)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BridgeError.BRIDGE_FORM.message());
        }

        @DisplayName("숫자가 3 - 20 범위가 아니라면 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 50, -1})
        void isValidRange(int size) {
            Assertions.assertThatThrownBy(() -> new BridgeSize(size))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(BridgeError.BRIDGE_LENGTH.message());
        }
    }

    public static InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}