package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("주어진 길이에 합당한 다리를 생성")
    @ParameterizedTest
    @ValueSource(ints = {5, 8, 11, 13})
    void buildBridgeTest(int input) {
        // Given

        // When
        List<String> bridge = bridgeMaker.makeBridge(input);

        // Then
        assertThat(bridge.size()).isEqualTo(input);
    }

    @DisplayName("생성한 다리의 값들이 유효함")
    @Test
    void validBridgeTest() {
        // Given
        int bridgeLength = 10;

        // When
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);

        // Then
        assertThat(bridge).containsOnly("U", "D");
    }
}