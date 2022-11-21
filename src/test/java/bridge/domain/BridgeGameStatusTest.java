package bridge.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameStatusTest {

    private BridgeGameStatus bridgeGameStatus;

    public BridgeGameStatusTest() {
        bridgeGameStatus = new BridgeGameStatus();
    }

    @DisplayName("초기상태 게임을 진행할수있는지 체크한다.")
    @Test
    public void can_Play_Game_Init() {
        boolean answer = true;
        assertEquals(answer, bridgeGameStatus.canPlayGame());
    }

    @DisplayName("게임 정지 후 진행불가 상태 확인")
    @Test
    public void stop_Play_Game() {
        bridgeGameStatus.updateStatus(Status.FAIL);
        boolean answer = false;
        assertEquals(answer, bridgeGameStatus.canPlayGame());
    }

    @DisplayName("게임 정지 후 다시 재시작시 게임이 진행가능 상태인지")
    @Test
    public void retry_Game_Check_Can_Play() {
        assertAll(
                () -> {
                    boolean falseAnswer = false;
                    bridgeGameStatus.updateStatus(Status.FAIL);
                    assertEquals(falseAnswer, bridgeGameStatus.canPlayGame());
                },
                () -> {
                    boolean trueAnswer = true;
                    bridgeGameStatus.retryStatus();
                    assertEquals(trueAnswer, bridgeGameStatus.canPlayGame());
                }
        );
    }

    @DisplayName("재시도 후 시도횟수 2회로 변경")
    @Test
    public void retry_Game_tryCount() {
        int answer = 2;
        bridgeGameStatus.retryStatus();
        assertEquals(bridgeGameStatus.getTryCount(),answer);
    }

}