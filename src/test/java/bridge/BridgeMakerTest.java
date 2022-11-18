package bridge;

import static bridge.BridgeMaker.DOWN_STAIRS;
import static bridge.BridgeMaker.UP_STAIRS;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @Test
    @DisplayName("[makeBridge] 사용자의 다리 사이즈 만큼 올바르게 다리를 생성하는지 테스트")
    void makeBridgeCorrectSize() {
        //given
        int userInput=4;
        //when
        List<String> bridge = bridgeMaker.makeBridge(userInput);
        //then
        assertThat(bridge.size()).isEqualTo(userInput);
    }

    @Test
    @DisplayName("[makeBridge] 다리가 U 혹은 D만을 생성하는지 테스트")
    void makeCorrectBridge() {
        //given
        int userInput=12;
        //when
        List<String> bridge = bridgeMaker.makeBridge(userInput);
        //then
        assertThat(bridge).containsAnyOf(UP_STAIRS,DOWN_STAIRS);

    }
}