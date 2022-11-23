package bridge.service;

import bridge.domain.CurrentBridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void clear() {
        this.bridgeGame = new BridgeGame(3);
    }

    @Test
    @DisplayName("move 메서드는 파라미터에 따라 CurrentBridge 객체의 값을 변화시킨다.")
    void move() {
        // given
        String readMoving = "U";

        // when
        CurrentBridge currentBridge = bridgeGame.move(readMoving);

        // then
        assertEquals(1, currentBridge.getUpperSection().size());
        assertEquals(1, currentBridge.getLowerSection().size());
        assertTrue(bridgeGame.getGameManager().containsKey("isOneGameEnd"));
    }

    @Test
    @DisplayName("retry 메서드는 BridgeGame의 인스턴스 변수를 일부 초기화시킨다.")
    void retry() throws NoSuchFieldException, IllegalAccessException {
        // given
        CurrentBridge currentBridge = bridgeGame.move("U");

        // when
        bridgeGame.retry();

        // then
        assertEquals(0, bridgeGame.getGameManager().size());
        Field currentSection = BridgeGame.class.getDeclaredField("currentSection");
        currentSection.setAccessible(true);
        assertEquals(1 , currentSection.getInt(bridgeGame));
        assertNotSame(currentBridge, bridgeGame.move("U"));
    }
}