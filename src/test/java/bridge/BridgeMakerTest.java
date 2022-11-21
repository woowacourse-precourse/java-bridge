package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("다리 생성 후 저장 및 불러오기")
    @Test
    void 다리_저장_불러오기() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeMaker.makeBridge(4);
        assertThat(bridgeMaker.getBridge()).containsExactly("D", "D", "U", "U");
    }

    @DisplayName("현재 다리 상황 생성 후 저장 및 불러오기")
    @Test
    void 현재_다리_상황_저장_불러오기() {
        HashMap<String, List<String>> presentBridge = new HashMap<>();
        presentBridge.put("U", List.of(" ", " ", "O", "O"));
        presentBridge.put("D", List.of("O", "O", " ", " "));
        BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(0, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        bridgeMaker.initPresentBridge();
        bridgeMaker.setPresentBridge(presentBridge);

        assertThat(presentBridge).isEqualTo(bridgeMaker.getPresentBridge());
    }
}