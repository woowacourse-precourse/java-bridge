package bridge;

import bridge.domain.BridgeGame;
import bridge.service.BridgeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeGameTest {

    List<String> answerBridge;
    int answerCount;

    @BeforeEach
    void setup(){
        BridgeService.makeBridge(3);
        answerBridge = BridgeService.getAnswerBridge();
        answerCount = 0;
    }

    @DisplayName("칸 이동시, O 또는 X 리턴하는지 테스트")
    @Test
    void checkMoveOXTest() {
        String result = BridgeGame.move("U");
        if(answerBridge.get(answerCount).equals("U")){
            assertThat(result).isEqualTo("O");
            return;
        }
        assertThat(result).isEqualTo("X");
    }

}