package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BridgeIdentifierTest {

    @DisplayName("1, 0은 각각 U, D로 변환된다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0:D",
            "1:U",
            "1:U",
            "0:D",
            "1:U",
            "0:D"
    }, delimiter = ':')
    void convertNumberToDirectionTest(int number, String direction) {
        assertThat(BridgeIdentifier.convertNumberToDirection(number)).isEqualTo(direction);
    }
}
