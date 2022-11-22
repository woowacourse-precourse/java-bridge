package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeExceptionTest {
    @DisplayName("다리의 길이가 3이상 20이하가 아닐시 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {1,2,21,22})
    public void LengthText(int size) {
        assertThatThrownBy(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeMaker.makeBridge(size);
        }).isInstanceOf(IllegalStateException.class);
    }
}
