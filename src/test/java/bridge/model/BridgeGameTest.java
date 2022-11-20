package bridge.model;

import bridge.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp(){
        bridgeGame = mock(BridgeGame.class);
    }

    @Test
    void whenMoveCalledVerified(){
        Mockito.doNothing().when(bridgeGame).move(isA(String.class));
        bridgeGame.move("U");

        verify(bridgeGame,times(1)).move("U");
    }
}
