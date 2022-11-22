package bridge;

import bridge.domain.BridgeGame;
import bridge.service.BridgeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeGameTest {

    List<String> answerBridge;

    @BeforeEach
    void setup() {
        BridgeService.makeBridge(3);
        answerBridge = BridgeService.getAnswerBridge();
    }

    @DisplayName("칸 이동시, O 또는 X 리턴하는지 테스트")
    @Test
    void checkMoveOXTest() {
        String result = BridgeGame.move("U");
        if (answerBridge.get(0).equals("U")) {
            assertThat(result).isEqualTo("O");
            return;
        }
        assertThat(result).isEqualTo("X");
    }

    @DisplayName("칸 이동시, 틀린 경우 테스트")
    @Test
    void checkBreakCompareFailTest() {
        int result = BridgeGame.breakCompare("X");
        assertThat(result).isEqualTo(1);
    }
}