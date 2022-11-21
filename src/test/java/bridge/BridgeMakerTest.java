package bridge;

import bridge.game.BridgeMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    @DisplayName("주어진 사이즈 길이만큼의 list를 반환해야 한다")
    @Test
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list = bridgeMaker.makeBridge(7);
        Assertions.assertThat(7).isEqualTo(list.size());
    }
}