package bridge;

import java.util.List;
import bridge.utils.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThatCode;

class BridgeMakerTest {
    @DisplayName("다리가 정상적으로 만들어지는지 확인")
    @Test
    void testMakeBridge() {
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = maker.makeBridge(5);
        for (String direction : bridge) {
            assertThatCode(() -> Validator.validateMove(direction))
                    .doesNotThrowAnyException();
        }
    }
}