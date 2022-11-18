package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final InputView inputView = new InputView();

    @Test
    void readBridgeSizeTest() {
        int bridgeSize = inputView.readBridgeSize("13");

        assertThat(bridgeSize).isEqualTo(13);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "21", "2147483648", "-2147483648", "이십칠", "5ㅋ", "@"})
    void readBridgeSizeExceptionTest(String bridgeSize) {

        assertThatThrownBy(() -> inputView.readBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
