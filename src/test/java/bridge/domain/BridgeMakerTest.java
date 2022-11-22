package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {

    @DisplayName("입력한 다리 사이즈만큼 위 아래 정보를 잘 생성하는지 확인")
    @Test
    public void makeBridgeTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(3);

        Assertions.assertThat(bridge).containsOnly("U", "D");
    }
}
