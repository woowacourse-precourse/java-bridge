package bridge;

import bridge.ApplicationTest.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeMakerTest {

    @Test
    @DisplayName("다리의 길이를 주면 길이만큼의 1이면 U 0이면 D의 다리를 생성한다.")
    void makeBridge() {
        // given
        int size = 3;
        ArrayList<Integer> tmpBridge = newArrayList(1, 0, 0);

        // when
        BridgeNumberGenerator testNumberGenerator = new TestNumberGenerator(tmpBridge);
        BridgeMaker bridgeMaker = new BridgeMaker(testNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertEquals(3, bridge.size());
        assertEquals(List.of("U","D","D"), bridge);
    }
}