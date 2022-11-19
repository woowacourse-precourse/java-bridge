package bridge.game;

import bridge.enums.IntEnum;
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
        for(int bridgeIndex=0;bridgeIndex<bridge.size();bridgeIndex++){
            gameResult.add(bridgeGame.move("U"));
        }
        Assertions.assertThat(gameResult).isEqualTo(List.of(1,1,1,1));

    }
    @Test
    public void nowBridgePrintTest() throws Exception{
        //given
        List<String > bridge = List.of("U","D","U","U","D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.nowBridgeStage(IntEnum.GAME_CONTINUE.num());
        bridgeGame.nowBridgeStage(IntEnum.GAME_CONTINUE.num());
        bridgeGame.nowBridgeStage(IntEnum.GAME_CONTINUE.num());
        bridgeGame.nowBridgeStage(IntEnum.GAME_CONTINUE.num());
        StringBuilder result = new StringBuilder("[ O |   | O | O |   ]\n");
        result.append("[   | O |   |   | O ]");
        assertEquals(bridgeGame.nowBridgeStage(IntEnum.GAME_CONTINUE.num()),result.toString());
    }

}