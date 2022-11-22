package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.ErrorMessages;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Bridge Maker 다리 생성 기능 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeMakerTest {

    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 21})
    void 범위를_벗어난_크기_지정시_예외_발생(int size) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_BRIDGE_SIZE);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 20})
    void 다리_생성시_크기_확인(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge).isNotEmpty()
                .hasSize(size);
    }

    @Test
    void 다리_생성후_구성_요소_확인() {
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsOnly("U", "D");
    }
}
