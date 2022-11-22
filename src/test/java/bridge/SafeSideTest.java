package bridge;

import static bridge.util.Constants.COLON;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.util.SafeSide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SafeSideTest {

    @DisplayName("1을 입력하면 U를, 0을 입력하면 D를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:U", "0:D"}, delimiter = COLON)
    void oneForUpAndZeroForDown(int number, String expectedSafeSide) {
        assertThat(SafeSide.chooseUpOrDown(number)).isEqualTo(expectedSafeSide);
    }
}