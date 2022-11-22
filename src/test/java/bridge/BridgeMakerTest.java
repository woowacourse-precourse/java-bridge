package bridge;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeMakerTest {
    @DisplayName("다리가 0일 때 D, 1일 때 U로 리스트가 만들어 지는지 테스트")
    @Test
    void makeBridgeTest(){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeRandomNumberGenerator);
        assertThat(bridgeMaker.makeBridgeList(5, List.of(1,0,1,0,1)))
                .isEqualTo(List.of("U","D","U","D","U"));
    }

    @DisplayName("다리가 0일 때 D, 1일 때 U로 리스트가 만들어 지는지 테스트")
    @Test
    void makeBridgeTest2() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertThat(bridgeMaker.makeBridgeList(5, List.of(0, 0, 0, 0, 0)))
                .isEqualTo(List.of("D", "D", "D", "D", "D"));
    }
}