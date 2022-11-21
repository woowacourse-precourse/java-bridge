package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest(name = "입력한 다리의 길이만큼 다리를 생성한다")
    @CsvSource("3,4,5,6,7,8,9,20")
    void makeBridge(int size) {
        BridgeSize bridgeSize = new BridgeSize(size);
        Bridge bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    @ParameterizedTest(name = "입력한 다리의 길이가 유효하지 않으면 오류가 발생한다")
    @CsvSource("2,21,,0,3.3")
    void makeBridgeThrowsError(int size) {
        BridgeSize bridgeSize = new BridgeSize(size);
        Bridge bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}