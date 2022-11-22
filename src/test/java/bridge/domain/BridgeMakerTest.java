package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("길이에 따른 다리 생성 - 정상 데이터를 입력한 경우")
    @ValueSource(ints = {3, 5, 10, 15, 20})
    @ParameterizedTest
    void checkNormalBridgeLength(int bridgeLength) {
        System.out.println(bridgeLength);
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);

        assertThat(bridge).size().isEqualTo(bridge.size());
    }

    @DisplayName("길이에 따른 다리 생성 - 예외 데이터를 입력한 경우")
    @ValueSource(ints = {1, 2, 21, 22, 100})
    @ParameterizedTest
    void checkErrorBridgeLength(int bridgeLength) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(bridgeLength))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
