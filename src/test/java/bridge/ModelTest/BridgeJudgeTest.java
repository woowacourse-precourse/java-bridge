package bridge.ModelTest;

import bridge.Model.BridgeJudge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeJudgeTest {
    BridgeJudge bridgeJudge = new BridgeJudge();
    @DisplayName("생성된 다리 ArrayList 와 사용자 방향 입력값을 받아서 두 개를 비교하여 같으면 True 반환, 다르면 False 를 반환한다.")
    @Test
    void 방향_입력값과_생성된_다리_비교() {
        int index = 0;
        String userInput = "U";
        List<String> bridge = new ArrayList<>(List.of("U","D","D","U","U"));
        assertThat(bridgeJudge.judgeInput(userInput, bridge, index)).isEqualTo(true);
    }
}
