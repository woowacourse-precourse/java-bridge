package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.BridgeMap;

import bridge.utils.constants.BridgeRoute;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMapTest {

    private static BridgeMap bridgeMap;

    @BeforeAll
    static void initBridgeMap(){
        bridgeMap = new BridgeMap(new Bridge(new ArrayList<>(List.of("U", "D", "U", "U", "D"))));
    }

    @DisplayName("2번째 정답칸으로 이동 시 upper에는 [O,공백] lower에는 [공백,O] 가 저장됨")
    @Test
    void caseMoveCorrect2Step(){
        bridgeMap.updateCurrentMap(1, true);
        List<String> upperMap =bridgeMap.getCurrentMap().get(BridgeRoute.UP.getRouth());
        List<String> lowerMap = bridgeMap.getCurrentMap().get(BridgeRoute.DOWN.getRouth());
        assertThat(upperMap).containsExactly("O"," ");
        assertThat(lowerMap).containsExactly(" ","O");
    }

    @DisplayName("3번째 오답칸으로 이동 시 upper에는 [O,공백, 공백] lower에는 [공백,O, X] 가 저장됨")
    @Test
    void caseMoveInCorrect3Step(){
        bridgeMap.updateCurrentMap(2, false);
        List<String> upperMap =bridgeMap.getCurrentMap().get(BridgeRoute.UP.getRouth());
        List<String> lowerMap = bridgeMap.getCurrentMap().get(BridgeRoute.DOWN.getRouth());
        assertThat(upperMap).containsExactly("O"," ", " ");
        assertThat(lowerMap).containsExactly(" ","O", "X");
    }
}
