package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    @Test
    void 다리길이만큼_다리생성() {
//        List bridge = new ArrayList();
        List bridge = bridgeMaker.makeBridge(4);
        Assertions.assertThat(bridge.size()).isEqualTo(4);
        Assertions.assertThat(bridge).isInstanceOf(List.class);

    }

}