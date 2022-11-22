package bridge;

import static bridge.util.Constants.COLON;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {

    @DisplayName("입력값에 해당하는 길이의 다리를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "12:12", "15:15", "20:20"}, delimiter = COLON)
    void makeBridgeInGivenSize(int inputSize, int expectedSize) {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        final List<String> bridge = bridgeMaker.makeBridge(inputSize);

        assertThat(bridge.size()).isEqualTo(expectedSize);
    }
}