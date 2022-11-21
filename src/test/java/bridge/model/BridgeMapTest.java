package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapTest {

    @DisplayName("움직임이 주어졌을 때 해당 움직임에 해당하는 맵이 생성됨")
    @Test
    void createMapTest(){
        //given
        List<String> generatedMap = List.of("U","D","U");

        BridgeMap bridgeMap = BridgeMap.generateMap();
        BridgeMap bridgeMap2 = BridgeMap.generateMap();

        //when
        bridgeMap.insertMove("O",0);
        bridgeMap.insertMove("O",1);
        bridgeMap.insertMove("O",0);

        bridgeMap2.insertMove("O",0);
        bridgeMap2.insertMove("X",0);

        //then
        assertThat(bridgeMap.toString()).isEqualTo("[ O |   | O ]\n[   | O |   ]");
        assertThat(bridgeMap2.toString()).isEqualTo("[ O | X ]\n[   |   ]");
    }
}
