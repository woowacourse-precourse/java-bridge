package bridge.domain;


import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("세 번 모두 1이 나왔을 경우 Test")
    @Test
    public void makingBridgeUpperShapeTest() throws Exception {
        BridgeNumberGenerator generator = () -> 1;
        List<String> givenBridge = List.of("U", "U", "U");
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        Assertions.assertThat(bridgeMaker.makeBridge(3)).isEqualTo(givenBridge);
    }

    @DisplayName("세 번 모두 0이 나왔을 경우 Test")
    @Test
    public void makingBridgeDownShapeTest() throws Exception {
        BridgeNumberGenerator generator = () -> 0;
        List<String> givenBridge = List.of("D", "D", "D");
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        Assertions.assertThat(bridgeMaker.makeBridge(3)).isEqualTo(givenBridge);
    }


}
