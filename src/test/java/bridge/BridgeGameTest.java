package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("이동 횟수 테스트")
    @Test
    public void moveTest(){
        BridgeGame bridgeGame = new BridgeGame();
        int randomNumber = Randoms.pickNumberInRange(1,9);
        repeatMove(bridgeGame, randomNumber);
        assertThat(bridgeGame.getPosition().get(1)).isEqualTo(randomNumber);
    }

    private void repeatMove(BridgeGame bridgeGame,int randomNumber){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        for(int i=0; i<randomNumber; i++){
            int upOrDownNumber = bridgeRandomNumberGenerator.generate();
            if(upOrDownNumber == 0){
                bridgeGame.move("D");
            }
            if(upOrDownNumber == 1){
                bridgeGame.move("U");
            }
        }
    }

}
