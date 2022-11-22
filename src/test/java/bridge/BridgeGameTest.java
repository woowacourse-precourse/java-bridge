package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void comparingAnswerTest(){
        List<String> bridgeAnswer = Arrays.asList("U", "D","U","U","D","D","U");
        List<Integer> round = Arrays.asList(1,2,3,4,5);
        List<Boolean> expected = Arrays.asList(true,false,false,true,true);
        BridgeGame bridgeGame = new BridgeGame();
        String userInput = "D";
        for(int i=0; i<5; i++){
            assertThat(bridgeGame.move(userInput,bridgeAnswer,round.get(i))).isEqualTo(expected.get(i));
        }

    }
}