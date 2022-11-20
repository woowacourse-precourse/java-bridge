package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @DisplayName("이동 테스트")
    @Test
    public void moveTest(){
        BridgeGame bridgeGame = new BridgeGame();
        int randomNumber = Randoms.pickNumberInRange(1,9);
        for(int i=0; i<randomNumber; i++){
            bridgeGame.move();
        }
        assertThat(bridgeGame.getPosition()).isEqualTo(randomNumber);
    }

    @DisplayName("재시도 테스트")
    @Test
    public void retryTest(){
        BridgeGame bridgeGame = new BridgeGame();
        int randomNumber = Randoms.pickNumberInRange(1,9);
        for(int i=0; i<randomNumber; i++){
            bridgeGame.retry();
        }
        assertThat(bridgeGame.getPosition()).isEqualTo(-randomNumber);
        assertThat(bridgeGame.getRetryNumber()).isEqualTo(randomNumber);
    }
}
