package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeMakerTest {
    @Test
    @DisplayName("생성된 다리가 U 또는 D 값으로 표현됐는지 테스트")
    void bridgeValidTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(3);
        for (String str : bridge) {
            assertThat(str == "U" || str == "D").isTrue();
        }
    }

    @Test
    @DisplayName("다리가 BridgeRandomNumberGenerator를 사용하여 생성되지 않았다면 예외가 발생한다")
    void bridgeExceptionTest() {
        BridgeNumberGenerator temp = () -> -1;
        BridgeMaker bridgeMaker = new BridgeMaker(temp);
        assertThrows(IllegalStateException.class, () -> {
            List<String> bridge = bridgeMaker.makeBridge(3);
        });
    }


}
