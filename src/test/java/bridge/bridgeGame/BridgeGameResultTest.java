package bridge.bridgeGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameResultTest {

    BridgeGameResult bridgeGameResult = new BridgeGameResult();
    
    @Test
    @DisplayName("사용자가 이동하려는 방향이 U일때, 이동이 가능하면 O를 불가능하면 X를 입력한다.")
    void addResultUp() {
        //given
        List<Boolean> enableMove = Arrays.asList(true, false);
        List<String> expectResult = Arrays.asList("O", "X");

        //when
        enableMove.forEach(enable -> bridgeGameResult.addResultUp(enable));

        //then
        assertEquals(expectResult, bridgeGameResult.getResultUp());
    }

    @Test
    void addResultDown() {
    }

    @Test
    void retryResultUpDown() {
    }
}