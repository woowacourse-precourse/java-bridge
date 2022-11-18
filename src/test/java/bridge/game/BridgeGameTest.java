package bridge.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    @Test
    public void moveTest() throws Exception{
        //given
        List<String > bridge = List.of("U","U","U","U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        List<Integer> gameResult = new ArrayList<>();
        for(int i=0;i<bridge.size();i++){
            gameResult.add(bridgeGame.move("U"));
        }
        Assertions.assertThat(gameResult).isEqualTo(List.of(1,1,1,0));

    }

}