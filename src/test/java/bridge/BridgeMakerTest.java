package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker =
            new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리 크기를 크게 설정한경우 오류를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {21,100,10000})
     void throwErrorIfBridgeSizeIsTooLarge(int size) {
        Assertions.assertThatThrownBy(() -> bridgeMaker.validate(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 크기를 작게 설정한경우 오류를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {2,1,-100})
     void throwErrorIfBridgeSizeIsTooSmall(int size) {
        Assertions.assertThatThrownBy(() -> bridgeMaker.validate(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 크기를 적절하게 설정한 경우 정 사이즈의 다리를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3,6,10})
     void returnBridgeIfBridgeSizeIsValid(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertThat(bridge.size()).isEqualTo(size);
    }

}