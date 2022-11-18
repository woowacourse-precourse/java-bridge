package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    @DisplayName("size 3~20 사이의 수인지 테스트")
    void validSizeTest() {
        assertThat(InputView.isValidSize(3)).isTrue();
        assertThat(InputView.isValidSize(20)).isTrue();
        assertThat(InputView.isValidSize(2)).isFalse();
        assertThat(InputView.isValidSize(21)).isFalse();
    }
}
