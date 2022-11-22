package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    @DisplayName("입력받은 다리 길이에 맞게 생성되었는지 테스트")
    @Test
    public void makeBridgeSizeTest() {
        int bridgeLength = 3;
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(1,1,1));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);

        assertThat(bridge.size()).isEqualTo(bridgeLength);


    }

    @DisplayName("컴퓨터가 랜덤하게 생성한 숫자에 따른 D,U 추가 테스트")
    @Test
    public void checkRightComputerMakeBridgeTest() {
        int BridgeLength = 3;
        List<String> answer = List.of("U","U","U");
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(1,1,1));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


        List<String> bridge = bridgeMaker.makeBridge(BridgeLength);

        assertThat(bridge).isEqualTo(answer);

    }

}
