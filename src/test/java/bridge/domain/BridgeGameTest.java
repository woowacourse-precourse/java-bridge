package bridge.domain;

import bridge.type.ResultType;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class BridgeGameTest {

    @InjectMocks
    private BridgeGame target;
    private int bridgeSize = 5;
    List<String> sampleBridge = List.of("U", "D", "U", "D", "U");
    BridgeGame bridgeGame = new BridgeGame(sampleBridge, new MoveLog(sampleBridge.size()));

    @DisplayName("입력한 길이의 다리를 생성하는지 확인")
    @Test
    void checkBridgeSize() {
        Assertions.assertThat(bridgeGame.getBridgeSize()).isEqualTo(bridgeSize);
    }

    @DisplayName("오답인 다리를 선택했을 때 실패가 나오는지 확인")
    @Test
    void checkResultByWrongMove() {
        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(ResultType.FAIL);
    }

    @DisplayName("정답인 다리를 선택했을 때 성공이 나왔는지 확인")
    @Test
    void checkResultByCorrectMove() {
        Assertions.assertThat(bridgeGame.move("U")).isEqualTo(ResultType.SUCCESS);
    }


}