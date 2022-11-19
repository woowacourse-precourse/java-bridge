package bridge.ViewTest;

import bridge.Model.Bridge;
import bridge.Model.BridgeJudge;
import bridge.View.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputViewTest {
    Bridge bridge = new Bridge();
    BridgeJudge bridgeJudge = new BridgeJudge();
    OutputView outputView = new OutputView();
    @DisplayName("비교 결과에 따라 라운드마다 결과를 출력한다.")
    @Test
    void 비교_결과_출력() {
        String userInput = "U";
        String madeBridge = "U";
        bridgeJudge.judgeInput(userInput, madeBridge, bridge);
        outputView.printMap(bridge, 1);
        assertThat(outputView.getString()).isEqualTo("[ O ]\n" + "[   ]");
    }
}
