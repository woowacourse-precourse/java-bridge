package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    @DisplayName("사이즈가 3미만인 크기를 입력하였을 때 예외 발생")
    @Test
    void 다리_생성_크기가_3보다_작을떄_예외발생() {
        Assertions.assertThatThrownBy(()->bridgeMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사이즈가 20 초과인 크기를 입력하였을 때 예외 발생")
    @Test
    void 다리_생성_크기가_20보다_클떄_예외발생(){
        Assertions.assertThatThrownBy(()->bridgeMaker.makeBridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }
}