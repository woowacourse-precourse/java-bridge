package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import bridge.exception.ErrorMessage;
import bridge.exception.InvalidInputException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("사이즈에 맞는 다리 생성")
    @Test
    void makeBridge() {
        int size = 10;
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge).hasSize(size);
    }

    @DisplayName("범위를 벗어나는 다리 길이 입력 시 예외 발생")
    @ValueSource(ints = { Bridge.MINIMUM_LENGTH - 1, Bridge.MAXIMUM_LENGTH + 1 })
    @ParameterizedTest
    void testInvalidBridgeLength(int size) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
            .isInstanceOf(InvalidInputException.class)
            .hasMessageContaining(ErrorMessage.BRIDGE_LENGTH_IS_BETWEEN_3_AND_20);
    }

}
