package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeVerifierTest {
    @ParameterizedTest
    @CsvSource(value = {"1a", "2", "21"})
    void invalidBridgeSizeTest(String input) {
        assertThatThrownBy(() -> BridgeVerifier.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:3", "20:20"}, delimiter = ':')
    void validBridgeSizeTest(String input, int expected) {
        assertThat(BridgeVerifier.validateBridgeSize(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "U2", "DD"})
    void invalidateMovingTest(String input) {
        assertThatThrownBy(() -> BridgeVerifier.validateMoving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
    void validBridgeSizeTest(String input, String expected) {
        assertThat(BridgeVerifier.validateMoving(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"A", "RR", "Q2"})
    void invalidateGameCommandTest(String input) {
        assertThatThrownBy(() -> BridgeVerifier.validateGameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"R:R", "Q:Q"}, delimiter = ':')
    void validateGameCommandTest(String input, String expected) {
        assertThat(BridgeVerifier.validateGameCommand(input)).isEqualTo(expected);
    }
}