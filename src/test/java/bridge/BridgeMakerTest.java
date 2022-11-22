package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("BridgeMaker 테스트")
    @Test
    void bridgeMakeTest(){
        List<String> bridge = bridgeMaker.makeBridge(3);

        org.assertj.core.api.Assertions.assertThat(bridge.size()).isEqualTo(3);
    }

}