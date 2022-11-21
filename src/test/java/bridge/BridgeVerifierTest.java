package bridge;

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
}