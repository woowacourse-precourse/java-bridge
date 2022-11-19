package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.errorenum.ErrorMessage;
import bridge.util.BridgeMaker;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {
    private static final String ERROR_HEAD = "[ERROR]";
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("다리 생성 시, 다리 길이가 범위 외의 값이면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {2, 21, 0})
    void createBridgeOutOfLength(int size) {
        List<String> innerBridge = bridgeMaker.makeBridge(size);

        assertThatThrownBy(() -> new Bridge(innerBridge))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_IN_RANGE.printMessage())
                .hasMessageStartingWith(ERROR_HEAD);
    }

    @DisplayName("다리 생성 시, 다리 길이가 범위 내의 값이면 객체가 정상 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {3, 20})
    void createBridgeInLength(int size) {
        List<String> innerBridge = bridgeMaker.makeBridge(size);

        Bridge bridge = new Bridge(innerBridge);

        assertThat(bridge).isInstanceOf(Bridge.class);
    }

}
