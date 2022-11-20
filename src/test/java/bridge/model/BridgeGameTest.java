package bridge.model;

import bridge.BridgeGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @DisplayName("void 반환 타입인 move 메서드 기능 테스트")
    @Test
    void whenMoveCalledVerified(){
        bridgeGame = mock(BridgeGame.class);
        Mockito.doNothing().when(bridgeGame).move(isA(String.class));
        bridgeGame.move("U");

        verify(bridgeGame,times(1)).move("U");
    }

    @DisplayName("재시도 횟수 +1 카운트 테스트")
    @Test
    void generateRetryCount(){
        //given
        int expectedResult=2;

        //when
        bridgeGame.countRetry();

        //then
        Assertions.assertEquals(expectedResult,bridgeGame.getRetryCount());
    }
}
