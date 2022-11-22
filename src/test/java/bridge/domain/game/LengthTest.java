package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LengthTest {

    @ParameterizedTest
    @CsvSource({"'30'", "''", "'4$'"})
    void createLengthBy(String size) {
        assertThatThrownBy(() -> new Length(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}