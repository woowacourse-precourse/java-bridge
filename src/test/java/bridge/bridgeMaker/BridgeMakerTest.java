package bridge.bridgeMaker;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.type.ValidationType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {

    @DisplayName("입력 사이즈에 따른 다리 생성 테스트")
    @ValueSource(ints = {3, 5, 10, 20})
    @ParameterizedTest
    void makeBridgeTest(Integer size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> madeBridge = bridgeMaker.makeBridge(size);
        assertThat(madeBridge.stream()
                .filter(input -> ValidationType.CHECK_MOVING.getValidationRange().contains(input))
                .count()).isEqualTo(madeBridge.size());
    }
}
