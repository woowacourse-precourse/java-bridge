package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @DisplayName("다리의 길이가 3보다 작거나 20보다 크다면 예외가 발생한다.")
    @ValueSource(strings = {"2", "21", "-1"})
    @ParameterizedTest
    void createBridgeByInvalidSize(Integer size) {
        assertThatThrownBy(
            () -> new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size)).isInstanceOf(
            IllegalArgumentException.class);
    }

}