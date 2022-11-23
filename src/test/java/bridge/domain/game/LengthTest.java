package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LengthTest {

    @DisplayName("다리 길이가 3 이상 20 이하 숫자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"'0'", "-1", "'21'", "'r'", "'4$'", "''", "' '"})
    void createLength_with_invalid_size(String size) {
        assertThatThrownBy(() -> new Length(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
