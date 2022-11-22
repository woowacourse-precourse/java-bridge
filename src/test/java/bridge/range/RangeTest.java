package bridge.range;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RangeTest {

    @DisplayName("contains: expected true")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "1, 10, 5",
            "10, 1, 5",
            "-10, -1, -5",
            "-1, -10, -5",
            "0, 0, 0"
    })
    void containsTrue(
            final int fromInclusive,
            final int toInclusive,
            final int value
    ) {
        final Range actualRange = Range.between(fromInclusive, toInclusive);
        assertThat(actualRange.contains(value)).isTrue();
    }

    @DisplayName("contains: expected false")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource({
            "1, 10, 15",
            "10, 1, 15",
            "-10, -1, -15",
            "-1, -10, -15",
            "0, 0, 5"
    })
    void containsFalse(
            final int fromInclusive,
            final int toInclusive,
            final int value
    ) {
        final Range actualRange = Range.between(fromInclusive, toInclusive);
        assertThat(actualRange.contains(value)).isFalse();
    }
}