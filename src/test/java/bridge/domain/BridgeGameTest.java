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

    @DisplayName("재시도 후 시도횟수가 올바르게 증가하는지 확인")
    @Test
    void checkTrialAfterRetry() {
        bridgeGame.retry();
        bridgeGame.retry();
        Assertions.assertThat(bridgeGame.getTrial()).isEqualTo(3);
    }

    @DisplayName("이동 후 사용자의 현재 위치가 올바르게 변하는지 확인")
    @Test
    void checkIndexAfterMove() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        Assertions.assertThat(bridgeGame.getIndex()).isEqualTo(2);
    }

}