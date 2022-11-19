package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    @DisplayName("size가 3~20 사이의 수인지 테스트")
    void validSizeTest() {
        assertThat(InputView.isValidSize(3)).isTrue();
        assertThat(InputView.isValidSize(20)).isTrue();
        assertThat(InputView.isValidSize(2)).isFalse();
        assertThat(InputView.isValidSize(21)).isFalse();
    }

    @Test
    @DisplayName("사용자가 입력한 문자가 U와D 중 하나인지 테스트")
    void validDirectionTest() {
        assertThat(InputView.isValidDirection("U")).isTrue();
        assertThat(InputView.isValidDirection("D")).isTrue();
        assertThat(InputView.isValidDirection("")).isFalse();
        assertThat(InputView.isValidDirection("A")).isFalse();
    }
}
