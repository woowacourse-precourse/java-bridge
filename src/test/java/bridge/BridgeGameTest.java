package bridge;


import bridge.Domain.BridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class BridgeGameTest {

    @DisplayName("정답 다리 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints={3,4,5})
    public void makeAnswerBridge(int num){
        final BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.makeAnswerBridge(num);
        assertThat(bridgeGame.getAnswerBridgeSize()).isEqualTo(num);
    }
    @DisplayName("이동 테스트")
    @Test
    public void movingResultTest(){
        final BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U");
        bridgeGame.move("U");

        assertThat(bridgeGame.getUserBridge()).isEqualTo(List.of("U","U"));
    }
    @DisplayName("해당 이동 결과 산출 테스트")
    @Test
    public void movingTest(){
        final BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setAnswerBridge(List.of("U","D","U"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.setMoveResult(0);
        bridgeGame.setMoveResult(1);
        assertThat(bridgeGame.getGameResult().getUpBridge()).isEqualTo(List.of("O","X"));
        assertThat(bridgeGame.getGameResult().getDownBridge()).isEqualTo(List.of(" "," "));
    }
    @DisplayName("게임 재시작 테스트")
    @Test
    public void replayTest(){
        final BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setAnswerBridge(List.of("U","D","D"));
        bridgeGame.retry();
        assertThat(bridgeGame.getRound()).isEqualTo(1);
        assertThat(bridgeGame.getAnswerBridge()).isEqualTo(List.of("U","D","D"));

    }


}
