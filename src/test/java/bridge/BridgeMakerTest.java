package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    @DisplayName("사이즈가 3미만인 크기를 입력하였을 때 예외 발생")
    @Test
    void makeUnderSizeBridge() {
        Assertions.assertThatThrownBy(()->bridgeMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사이즈가 20 초과인 크기를 입력하였을 때 예외 발생")
    @Test
    void makeOverSizeBridge(){
        Assertions.assertThatThrownBy(()->bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}