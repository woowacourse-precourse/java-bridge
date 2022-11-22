package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RetryOrQuitTest {
    @DisplayName("재시작/종료 여부는 R 또는 Q 이므로 길이가 1이어야 한다.")
    @Test
    void Retry_Or_Quit_len() {
        String RetryFlag = "AB";
        assertThatThrownBy(() -> Validator.validateGameCheckInputLen(RetryFlag)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("재시작/종료 여부는 R 또는 Q여야 한다.")
    @Test
    void Retry_Or_Quit() {
        String RetryFlag = "A";
        assertThatThrownBy(() -> Validator.validateGameCheck(RetryFlag)).isInstanceOf(
            IllegalArgumentException.class);
    }



}
