package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker testBridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    @DisplayName("만들어진 다리가 U나 D로 이루어져 있는지 확인")
    @Test
    void testBridgeUorD() {
        List<String> testbridge = testBridgeMaker.makeBridge(5);
        assertThat(testbridge.contains("U")||testbridge.contains("D"));
    }

    @DisplayName("만들어진 다리의 길이가 넣어준 사이즈와 같은지 비교")
    @Test
    void testBridgeSize() {
        List<String> testbridge = testBridgeMaker.makeBridge(7);
        assertTrue(testbridge.size()==7);
    }
}