package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidCheckTest {

    @Test
    void bridgeSize_성공하는경우() {
        for (int i = 3; i <= 20; i++) {
            assertThat(ValidCheck.bridgeSize(i + "")).isEqualTo(i);
        }
    }

    @Test
    void bridgeSize_실패하는경우() {
        List<String> Inputs = List.of("a", "00", "김", "21", "2", "3.1");
        for (String invalidInput : Inputs) {
            assertThatThrownBy(() -> ValidCheck.bridgeSize(invalidInput)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void upOrDown_성공하는경우() {
        List<String> Inputs = List.of("U", "D");
        for (String validInput : Inputs) {
            ValidCheck.upOrDown(validInput);
        }
    }

    @Test
    void upOrDown_실패하는경우() {
        List<String> Inputs = List.of("u", "d", "1", "UU");
        for (String invalidInput : Inputs) {
            assertThatThrownBy(() -> ValidCheck.upOrDown(invalidInput)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void retryOrQuit_성공하는경우() {
        List<String> Inputs = List.of("R", "Q");
        for (String invalidInput : Inputs) {
            ValidCheck.retryOrQuit(invalidInput);
        }
    }

    @Test
    void retryOrQuit_실패하는경우() {
        List<String> Inputs = List.of("r", "q", "3", "QQ");
        for (String invalidInput : Inputs) {
            assertThatThrownBy(() -> ValidCheck.retryOrQuit(invalidInput)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}