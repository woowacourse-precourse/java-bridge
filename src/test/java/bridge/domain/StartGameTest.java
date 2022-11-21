package bridge.domain;

import bridge.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StartGameTest {

    @DisplayName("정답 시 True 를 반환한다.")
    @Test
    void isRightWay_테스트() {
        Application.bridge = Arrays.asList("U", "D", "U");
        StartGame.movingInput = "U";
        Application.movingTurn = 0;
        assertTrue(StartGame.isRightWay());
    }

    @DisplayName("오답 시 True 를 반환한다.")
    @Test
    void isWrongWay_테스트() {
        Application.bridge = Arrays.asList("U", "D", "U");
        StartGame.movingInput = "D";
        Application.movingTurn = 0;
        assertTrue(StartGame.isWrongWay());
    }
}