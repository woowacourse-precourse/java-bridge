package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.util.SafeSide;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {
    @DisplayName("1을 입력하면 U를, 0을 입력하면 D를 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    void safeSideFromZeroOrOne(int randomNumber, String expectedLetter) {
        assertThat(SafeSide.chooseUpOrDown(randomNumber)).isEqualTo(expectedLetter);
    }

    @DisplayName("입력값에 해당하는 길이의 다리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "12:12", "15:15", "20:20"}, delimiter = ':')
    void makeBridgeInGivenSize(int size, int expectedLength) {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(expectedLength);
    }
}