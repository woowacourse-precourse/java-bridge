package bridge.view;

import bridge.domain.BridgeGame;
import bridge.model.Bridge;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @DisplayName("U를 선택했을 때 나오는 다리의 출력값 확인")
    @Test
    void outputViewTest() {
        //given
        OutputView outputView = new OutputView();
        List<String> bridge = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        StringBuilder upperBridge = new StringBuilder();
        StringBuilder lowerBridge = new StringBuilder();
        Bridge bridge1 = new Bridge(upperBridge, lowerBridge);
        //when
        bridgeGame.writeInitUpperBridge(upperBridge, lowerBridge, true);
        //then
        outputView.printMap(bridge1);
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
    }

    @DisplayName("다리 2칸 출력값 테스트")
    @Test
    void outputViewTest2() {
        //given
        OutputView outputView = new OutputView();
        List<String> bridge = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Bridge testBridge = new Bridge(sb, sb2);
        StringBuilder upperBridge = testBridge.getUpperBridge();
        StringBuilder lowerBridge = testBridge.getLowerBridge();
        //when
        bridgeGame.writeInitUpperBridge(upperBridge, lowerBridge, true);
        bridgeGame.writeUpperBridge(upperBridge, lowerBridge, true);
        //then
        outputView.printMap(testBridge);
        assertThat(output()).contains(
                "[ O | O ]",
                "[   |   ]"
        );
    }

    @DisplayName("다리 3칸 출력값 테스트")
    @Test
    void outputViewTest3() {
        //given
        OutputView outputView = new OutputView();
        List<String> bridge = new ArrayList<>(List.of("U", "D", "D", "U", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Bridge testBridge = new Bridge(sb, sb2);
        StringBuilder upperBridge = testBridge.getUpperBridge();
        StringBuilder lowerBridge = testBridge.getLowerBridge();
        //when
        bridgeGame.writeInitUpperBridge(upperBridge, lowerBridge, true);
        bridgeGame.writeUpperBridge(upperBridge, lowerBridge, true);
        bridgeGame.writeLowerBridge(upperBridge, lowerBridge, false);
        //then
        outputView.printMap(testBridge);
        assertThat(output()).contains(
                "[ O | O |   ]",
                "[   |   | X ]"
        );
    }

    @Override
    protected void runMain() {

    }
}