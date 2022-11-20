package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BridgeMakerTest {

    @DisplayName("다리 길이 입력 테스트")
    @ValueSource(strings = "3")
    @ParameterizedTest
    void makeBridgeTest(String inputSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        int size = Integer.parseInt(inputSize);
        List<String> bridge = bridgeMaker.makeBridge(size);

        Assertions.assertThat(bridge.size()).isEqualTo(size);
    }
}