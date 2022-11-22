package bridge.gamebridge;

import static bridge.result.GameResult.FAIL;
import static bridge.result.GameResult.PROGRESS;
import static bridge.result.GameResult.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.result.Result;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnswerBridgeTest {

    @DisplayName("입력된 다리가 건널수 있는 다리면 Progress GameStatus를 반환")
    @Test
    void inputBridgeToCross() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "U"));
        Bridge inputBridge = new Bridge(List.of("U", "D", "D"));
        AnswerBridge answerBridge = new AnswerBridge(bridge);

        Result result = answerBridge.checkBridge(inputBridge);

        assertThat(PROGRESS).isEqualTo(result.getGameStatus());
    }

    @DisplayName("입력된 다리가 건널수 없는 다리면 Fail GameStatus를 반환")
    @Test
    void inputImpenetrableBridge() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "U"));
        Bridge inputBridge = new Bridge(List.of("U", "D", "U"));
        AnswerBridge answerBridge = new AnswerBridge(bridge);

        Result result = answerBridge.checkBridge(inputBridge);

        assertThat(FAIL).isEqualTo(result.getGameStatus());
    }

    @DisplayName("입력된 다리가 정답 다리와 정확히 같으면 Success GameStatus를 반환")
    @Test
    void inputGameClearBridge() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "U"));
        Bridge inputBridge = new Bridge(List.of("U", "D", "D", "U", "U"));
        AnswerBridge answerBridge = new AnswerBridge(bridge);

        Result result = answerBridge.checkBridge(inputBridge);

        assertThat(SUCCESS).isEqualTo(result.getGameStatus());
    }
}
