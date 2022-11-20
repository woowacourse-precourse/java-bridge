package bridge;

import static bridge.domain.UpDownBridge.getDownBridge;
import static bridge.domain.UpDownBridge.getUpBridge;
import static bridge.domain.UpDownBridge.initBridge;
import static bridge.domain.UpDownBridge.makeUpDownBridge;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    BridgeGame bridgeGame = new BridgeGame();
    BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    List<String> bridges = bridgeMaker.makeBridge(3);
    String moveResult = bridgeGame.move(bridges.get(0), "U");

    @DisplayName("위,아래 다리 값 테스트")
    @Test
    void makeUpDownBridgeTest() {
        makeUpDownBridge("U", moveResult);
        String upBridge = getUpBridge().get(0);
        String downBridge = getDownBridge().get(0);
        assertEquals(upBridge, "O");
        assertEquals(downBridge, " ");
    }

    @DisplayName("위,아래 다리 초기화 테스트")
    @AfterEach
    @Test
    void UpDownBridgeInitTest() {
        initBridge();
        assertEquals(0, getUpBridge().size());
        assertEquals(0, getDownBridge().size());
    }
}
