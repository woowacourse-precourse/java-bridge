package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();

    @DisplayName("bridgeSize 를 입력받아 그 수만큼의 U 또는 D 로 만 이루어진 bridge 를 리턴한다.")
    @Test
    public void makeBridge() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        int bridgeSize = 3;

        //when
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        //then
        Assertions.assertThat(bridge.size()).isEqualTo(bridgeSize);
        Assertions.assertThat(bridge.contains("U") || bridge.contains("D")).isEqualTo(true);
    }

}