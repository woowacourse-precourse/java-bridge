package bridge;

import bridge.domain.user.MoveType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class BridgeMakerTest {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @DisplayName("다리 생성 사이즈 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 20})
    public void createBridgeSizeTest(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertThat(bridge.size()).isEqualTo(size);
    }

    @DisplayName("유효하지 않은 다리 타입 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 2})
    public void validateBridgeTypeTest(int typeNumber) {
        Assertions.assertThatThrownBy(() -> MoveType.convertType(typeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
