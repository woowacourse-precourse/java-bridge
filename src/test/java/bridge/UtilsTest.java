package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    @Test
    @DisplayName("size가 3~20 사이의 수인지 테스트")
    void validSizeTest() {
        assertThat(Utils.isValidSize(3)).isTrue();
        assertThat(Utils.isValidSize(20)).isTrue();
        assertThat(Utils.isValidSize(2)).isFalse();
        assertThat(Utils.isValidSize(21)).isFalse();
    }

    @Test
    @DisplayName("사용자가 입력한 문자가 U와D 중 하나인지 테스트")
    void validDirectionTest() {
        assertThat(Utils.isValidDirection("U")).isTrue();
        assertThat(Utils.isValidDirection("D")).isTrue();
        assertThat(Utils.isValidDirection("")).isFalse();
        assertThat(Utils.isValidDirection("A")).isFalse();
    }

    @Test
    @DisplayName("사용자가 입력한 문자가 R과Q 중 하나인지 테스트")
    void validCommandTest() {
        assertThat(Utils.isValidCommand("Q")).isTrue();
        assertThat(Utils.isValidCommand("R")).isTrue();
        assertThat(Utils.isValidCommand("")).isFalse();
        assertThat(Utils.isValidCommand("A")).isFalse();
    }
}
