package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class BridgeMakerTest {
    private final BridgeMaker bridgeMaker;

    public BridgeMakerTest() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("다리가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"5", "10", "15", "20"})
    public void makeBridge(int inputSize) {
        assertThatCode(() -> {
            List<String> bridge = bridgeMaker.makeBridge(inputSize);
            assertThat(bridge.size()).isEqualTo(inputSize);

        }).doesNotThrowAnyException();
    }

    @DisplayName("다리의 길이가 다를시 예외를 발생한다.")
    @Test
    public void checkBridgeSize() {
        assertThatCode(() -> {
            List<String> bridge = List.of("U", "U", "D");
            bridgeMaker.validateBridge(4, bridge);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.bridgeNotEqualsSize.getMessage());
    }

    @DisplayName("다리의 문자가 다를시 예외를 발생한다.")
    @Test
    public void checkBridgeWords() {
        assertThatCode(() -> {
            List<String> bridge = List.of("U", "U", "D", "K");
            bridgeMaker.validateBridge(4, bridge);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.createBridgeWordNotUD.getMessage());
    }
}