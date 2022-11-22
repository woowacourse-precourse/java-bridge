package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    BridgeMaker upBridgeMaker = new BridgeMaker(new BridgeNumberGenerator() {
        @Override
        public int generate() {
            return 1;
        }
    });

    BridgeMaker downBridgeMaker = new BridgeMaker(new BridgeNumberGenerator() {
        @Override
        public int generate() {
            return 0;
        }
    });



    @DisplayName("랜덤 숫자로 1이 나왔을때 생성되는 방향")
    @Test
    void makeUpBridgeTest() {
        List<String> bridge = upBridgeMaker.makeBridge(3);

        Assertions.assertThat(bridge).containsExactly("U","U","U");
    }

    @DisplayName("랜덤 숫자로 0이 나왔을때 생성되는 방향")
    @Test
    void makeDownBridgeTest() {
        List<String> bridge = downBridgeMaker.makeBridge(3);

        Assertions.assertThat(bridge).containsExactly("D","D","D");
    }

}