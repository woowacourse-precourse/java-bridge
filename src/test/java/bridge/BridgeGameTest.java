package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {

    @DisplayName("현재 입력과 다리 길 일치하는 경우 O 출력")
    @Test
    void moveCorrect() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","U","U"));
        bridgeGame.move("U");
        Assertions.assertEquals(bridgeGame.getUpMove().get(0), " O ");
    }
}
