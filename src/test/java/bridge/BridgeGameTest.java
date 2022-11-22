package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.InputView;
import ui.OutputView;

import java.util.List;

import static bridge.ApplicationTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BridgeGameTest {

    @DisplayName("다리를 생성하는 기능, 위 칸이면 \"U\", 아래 칸이면 \"D\"로 표현해야 한다.")
    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> newBridge = bridgeMaker.makeBridge(3);
        assertThat(newBridge).containsExactly("D", "U", "U");
    }

    @DisplayName("애플리케이션 실행 시 다리 길이를 입력받아 리턴한다.")
    @Test
    void createBridgeTest() {
        BridgeGame bridgeGame = new BridgeGame(new OutputView(), new InputView());
        assertEquals(bridgeGame.createBridge(5).size(), 5);
    }
}
