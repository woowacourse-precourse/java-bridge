package bridge.domain;

import bridge.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private static BridgeGame bridgeGame;

    @BeforeAll
    public static void init() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("재시도 선택 시 객체를 초기화한다.")
    @Test
    void retry_테스트() {
        bridgeGame.upSide.upSideArr.add("U");
        bridgeGame.downSide.downSideArr.add(" ");
        bridgeGame.retry();
        assertEquals(bridgeGame.upSide.upSideArr.size(), 0);
        assertEquals(bridgeGame.downSide.downSideArr.size(), 0);
    }

    @DisplayName("재시도 선택 시 변수 값을 변화한다.")
    @Test
    void retry_테스트2() {
        bridgeGame.movingTurn = 3;
        Application.totalTrial = 6;
        bridgeGame.retry();
        assertEquals(bridgeGame.movingTurn, 0);
        assertEquals(Application.totalTrial, 7);
    }

    @DisplayName("정답 시 결과가 객체에 올바르게 입려되는지 확인")
    @Test
    void rightWayMove_테스트() {
        for (String e : Arrays.asList("U", "D")) {
            StartGame.movingInput = e;
            bridgeGame.rightWayMove();
        }
        assertEquals(bridgeGame.upSide.upSideArr, Arrays.asList("O", " "));
        assertEquals(bridgeGame.downSide.downSideArr, Arrays.asList(" ", "O"));
    }

    @DisplayName("오답 시 결과가 객체에 올바르게 입려되는지 확인")
    @Test
    void wrongWayMove_테스트() {
        for (String e : Arrays.asList("U", "D")) {
            StartGame.movingInput = e;
            bridgeGame.wrongWayMove();
        }
        assertEquals(bridgeGame.upSide.upSideArr, Arrays.asList("X", " "));
        assertEquals(bridgeGame.downSide.downSideArr, Arrays.asList(" ", "X"));
    }
    @DisplayName("정답 시 True 를 반환한다.")
    @Test
    void isRightWay_테스트() {
        Application.bridge = Arrays.asList("U", "D", "U");
        StartGame.movingInput = "U";
        bridgeGame.movingTurn = 0;
        assertTrue(bridgeGame.isRightWay());
    }

    @DisplayName("오답 시 True 를 반환한다.")
    @Test
    void isWrongWay_테스트() {
        Application.bridge = Arrays.asList("U", "D", "U");
        StartGame.movingInput = "D";
        bridgeGame.movingTurn = 0;
        assertTrue(bridgeGame.isWrongWay());
    }
}