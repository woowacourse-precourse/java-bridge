package bridge;

import bridge.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @DisplayName("다리의 길이는 3이상 20 이하이다.")
    @Test
    void bridgeLength() {
        ValidationUtil.isValidBridgeLength(3);
        ValidationUtil.isValidBridgeLength(20);

        assertThatThrownBy(() -> ValidationUtil.isValidBridgeLength(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LENGTH.getValue());
        assertThatThrownBy(() -> ValidationUtil.isValidBridgeLength(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LENGTH.getValue());
    }

    @DisplayName("U 혹은 D인지 확인한다.")
    @Test
    void isUpOrDown() {
        ValidationUtil.isUpOrDown("U");
        ValidationUtil.isUpOrDown("D");

        assertThatThrownBy(() -> ValidationUtil.isUpOrDown("R"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isUpOrDown("Q"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isUpOrDown("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isUpOrDown("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isUpOrDown("*"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
    }

    @DisplayName("R 혹은 Q인지 확인한다.")
    @Test
    void isRetryOrQuit() {
        ValidationUtil.isRetryOrQuit("R");
        ValidationUtil.isRetryOrQuit("Q");

        assertThatThrownBy(() -> ValidationUtil.isRetryOrQuit("U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isRetryOrQuit("D"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isRetryOrQuit("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isRetryOrQuit("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
        assertThatThrownBy(() -> ValidationUtil.isRetryOrQuit("*"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT.getValue());
    }
}
