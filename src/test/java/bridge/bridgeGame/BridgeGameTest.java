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
    @DisplayName("플레이어가 움직인 횟수가 다리의 길이와 일치하면 True(성공)를 반환한다.")
    void isSuccessGame() {
        //given
        List<String> userDirection = Arrays.asList("U","D","D");
        //when
        userDirection.forEach(direction -> bridgeGame.move(direction));
        //then
        assertTrue(bridgeGame.isSuccessGame());
    }

    @Test
    @DisplayName("움직일 수 있는 방향과 일치하면 이동횟수를 1 증가시킨다.")
    void move() {
        //given
        List<String> userDirection = Arrays.asList("U","D","D");
        //when
        userDirection.forEach(direction -> bridgeGame.move(direction));
        //then
        assertEquals(bridgeGame.getMoveCount(),3);
    }

    @Test
    @DisplayName("움직일 수 있는 방향과 같지 않다면 움직이지 않는다.")
    void notMove() {
        //given
        List<String> userDirection = Arrays.asList("D","U","U");
        //when
        userDirection.forEach(direction -> bridgeGame.notMove(direction));
        //then
        assertEquals(bridgeGame.getMoveCount(),0);
    }

    @Test
    void retry() {
    }
}