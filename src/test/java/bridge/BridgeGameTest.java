package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private static BridgeGame bridgeGame;
    private static GameInfo gameInfo;

    @BeforeAll
    static void initBridge() {
        gameInfo = new GameInfo();
        bridgeGame = new BridgeGame(List.of("U", "D", "U"), gameInfo);
    }

    @DisplayName("사용자 이동 칸 성공 테스트")
    @Test
    public void moveSuccess() {
        bridgeGame.checkSuccessOrFail("U");
        assertThat(gameInfo.getSuccessOrFail()).isTrue();
    }

    @DisplayName("사용자 이동 칸 실패 테스트")
    @Test
    public void moveFail() {
        bridgeGame.checkSuccessOrFail("D");
        assertThat(gameInfo.getSuccessOrFail()).isFalse();
    }

    @DisplayName("재시작 여부 묻는 메시지 반환 통과 테스트")
    @Test
    public void checkRetryMessage() {
        bridgeGame.checkSuccessOrFail("D");
        bridgeGame.move();
        assertThat(gameInfo.getGameRound()).isEqualTo("Retry");
    }

    @DisplayName("게임 종료 메시지 반환 통과 테스트")
    @Test
    public void checkGameOverMessage() {
        bridgeGame.checkSuccessOrFail("U");
        bridgeGame.move();
        bridgeGame.checkSuccessOrFail("D");
        bridgeGame.move();
        bridgeGame.checkSuccessOrFail("U");
        bridgeGame.move();
        assertThat(gameInfo.getGameRound()).isEqualTo("GameOver");
    }
}
