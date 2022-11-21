package bridge.ModelTest;

import bridge.Model.Bridge;
import bridge.Model.BridgeJudge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeJudgeTest {
    BridgeJudge bridgeJudge = new BridgeJudge();
    @DisplayName("생성된 다리 ArrayList 와 사용자 방향 입력값을 받아서 두 개를 비교하여 같으면 O 저장, 다르면 X 를 저장한다.")
    @Test
    void 방향_입력값과_생성된_다리_비교() {
        String userInput = "U";
        String madeBridge = "U";
        Bridge bridge = new Bridge();
        bridgeJudge.judgeInput(userInput, madeBridge, bridge);
        assertThat(bridge.getUp().get(0)).isEqualTo("O");
    }
}
