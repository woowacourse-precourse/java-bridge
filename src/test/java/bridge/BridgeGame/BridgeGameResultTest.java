package bridge.BridgeGame;

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
    @DisplayName("사용자가 이동하려는 방향이 D일때, 이동이 가능하면 O를 불가능하면 X를 입력한다.")
    void addResultDown() {
        //given
        List<Boolean> enableMove = Arrays.asList(false, true);
        List<String> expectResult = Arrays.asList("X", "O"); //false - X , true - O

        //when
        enableMove.forEach(enable -> bridgeGameResult.addResultDown(enable));

        //then
        assertEquals(expectResult, bridgeGameResult.getResultDown());
    }

    @Test
    @DisplayName("재시작 시, 사용자의 게임 결과를 초기화한다.")
    void retryResultUpDown() {
        //given ( 테스트를 위해 각 배열에 1개의 인자 넣음 )
        bridgeGameResult.addResultUp(true);
        bridgeGameResult.addResultDown(true);

        //when
        bridgeGameResult.retryResultUpDown();

        //then
        assertAll(
                () -> assertEquals(bridgeGameResult.getResultUp().size(), 0),
                () -> assertEquals(bridgeGameResult.getResultDown().size(), 0)
        );
    }
}