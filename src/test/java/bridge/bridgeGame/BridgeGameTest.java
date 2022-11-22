package bridge.bridgeGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    @DisplayName("테스트에 사용할 다리의 움직일 수 있는 방향")
    void beforeEach() {
        List<String> answerGameBridge = Arrays.asList("U", "D", "D");
        bridgeGame = new BridgeGame(answerGameBridge);
    }

    @Test
    @DisplayName("건널 수 있는 방향과 같으면 True를 반환하고, 다르면 False를 반환한다.")
    void isSameDirection() {
        //given
        List<String> userDirection = Arrays.asList("U","U");
        List<Boolean> expectDirection = Arrays.asList(true,false);
        List<Boolean> actualDirection = new ArrayList<>();

        //when
        userDirection.forEach(direction -> {
            actualDirection.add(bridgeGame.isSameDirection(direction));
            bridgeGame.move(direction);
        });

        //then
        assertEquals(expectDirection,actualDirection);
    }

    @Test
    void isSuccessGame() {
    }

    @Test
    void move() {
    }

    @Test
    void notMove() {
    }

    @Test
    void retry() {
    }
}