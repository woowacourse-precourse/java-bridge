package bridge.gmaebridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.gamebridge.AnswerBridge;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerBridgeTest {

    @DisplayName("입력된 다리가 건널수 있는 다리면 true를 반환")
    @Test
    void inputBridgeToCross() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "U"));
        Bridge inputBridge = new Bridge(List.of("U", "D", "D"));
        AnswerBridge answerBridge = new AnswerBridge(bridge);
        boolean answer = true;
        assertThat(answer).isEqualTo(answerBridge.checkBridge(inputBridge));
    }

    @DisplayName("입력된 다리가 건널수 없는 다리면 false를 반환")
    @Test
    void inputImpenetrableBridge() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "U"));
        Bridge inputBridge = new Bridge(List.of("U", "D", "U"));
        AnswerBridge answerBridge = new AnswerBridge(bridge);
        boolean answer = false;
        assertThat(answer).isEqualTo(answerBridge.checkBridge(inputBridge));
    }

}
