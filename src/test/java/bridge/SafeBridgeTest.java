package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.util.SafeBridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SafeBridgeTest {
    @DisplayName("숫자 1을 입력하면 U를, 0을 입력하면 D를 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    void safeBridgeFromRandomNumber(int randomNumber, String expectedLetter) {
        assertThat(SafeBridge.chooseUpOrDown(randomNumber)).isEqualTo(expectedLetter);
    }
}