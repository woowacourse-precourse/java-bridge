package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeStatusTest {
    @DisplayName("숫자 값에 따라 알맞은 문자로 변환하는지 확인한다.")
    @CsvSource(value = {"0:D", "1:U"}, delimiter = ':')
    @ParameterizedTest
    void testBridgeSize(int element, String expected) {
        assertThat(BridgeStatus.convertNumberToLetter(element)).isEqualTo(expected);
    }
}
