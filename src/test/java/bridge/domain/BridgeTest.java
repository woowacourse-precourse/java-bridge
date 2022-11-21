package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {
    @DisplayName("다리 길이가 3 이상 20이하가 아니라면 예외가 발생한다.")
    @ValueSource(strings = {"-3", "2", "21"})
    @ParameterizedTest
    void makeBridgeByOutOfRange(Integer size) {
        assertThatThrownBy(() -> {
            BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

            List<String> bridge = bridgeMaker.makeBridge(size);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
