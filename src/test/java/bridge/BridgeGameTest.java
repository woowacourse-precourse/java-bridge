package bridge;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    static BridgeGame bridgeGame = new BridgeGame(List.of("U","D","D"));


    @ParameterizedTest
    @ValueSource(strings = {"U", "D", "D"})
    void move(String input){
        bridgeGame.move(input);
        assertTrue(bridgeGame.checkBridgeAndPlayer());
    }

    @Test
    void isEnd() { // 위의 테스트후에 플레이어의 이동이 적용됨을 확인
        assertTrue(bridgeGame.isEndOfBridge());
    }

}