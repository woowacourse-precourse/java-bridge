package bridge;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


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

}
