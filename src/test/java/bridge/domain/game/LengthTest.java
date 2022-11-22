package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LengthTest {

    @DisplayName("다리 길이가 3 이상 20 이하가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"'0'", "-1", "'21'"})
    void createLength_with_invalid_size(String size) {
        assertThatThrownBy(() -> new Length(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이에 문자가 포함되어 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"'r'", "'4$'"})
    void createLength_with_invalid_format(String size) {
        assertThatThrownBy(() -> new Length(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 공백이면 예외가 발생한다.")
    @Test
    void createLength_with_blank() {
        assertThatThrownBy(() -> new Length(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}