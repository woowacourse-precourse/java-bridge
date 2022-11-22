package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ConstValue;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameTest {

    Bridge bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void clearBridgeGame() {
        bridge = new Bridge(Arrays.asList(ConstValue.UPPER_BRIDGE, ConstValue.LOWER_BRIDGE, ConstValue.LOWER_BRIDGE));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리 게임 관리 클래스를 생성한다.")
    @Test
    void createBridgeGame() {
        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
    }

    @DisplayName("정답인 다리 하나를 이동한다.")
    @Test
    void moveCorrectly() {
        String movingPlace = ConstValue.UPPER_BRIDGE;

        boolean isCorrect = bridgeGame.move(movingPlace);

        assertThat(isCorrect).isTrue();
    }

    @DisplayName("오답인 다리 하나를 이동한다.")
    @Test
    void moveIncorrectly() {
        String movingPlace = ConstValue.LOWER_BRIDGE;

        boolean isCorrect = bridgeGame.move(movingPlace);

        assertThat(isCorrect).isFalse();
    }

    @DisplayName("오답일 경우, 재시도를 한다면 시도 횟수가 증가하고, 게임 결과를 저장하는 list의 크기가 1 줄어든다.")
    @Test
    void increaseTryCount() {
        String movingPlace = ConstValue.LOWER_BRIDGE;
        boolean isCorrect = bridgeGame.move(movingPlace);

        String gameCommand = ConstValue.RETRY;
        bridgeGame.isRetry(gameCommand, isCorrect);

        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
        assertThat(bridge.toString()).isEqualTo("[]\n[]");
    }

    @DisplayName("다리를 모두 건넜다면, 게임은 종료된다.")
    @Test
    void gameTerminateByCompleteBridge() {
        bridgeGame.move(ConstValue.UPPER_BRIDGE);
        bridgeGame.move(ConstValue.LOWER_BRIDGE);
        bridgeGame.move(ConstValue.LOWER_BRIDGE);

        boolean isQuit = false;

        assertThat(bridgeGame.gameContinue(bridge, isQuit)).isFalse();
    }

    @DisplayName("다리를 모두 건너지 않았지만, 종료(Q)를 누르면, 게임은 종료된다.")
    @Test
    void gameTerminateByPressQButton() {
        bridgeGame.move(ConstValue.UPPER_BRIDGE);
        bridgeGame.move(ConstValue.LOWER_BRIDGE);

        boolean isQuit = true;

        assertThat(bridgeGame.gameContinue(bridge, isQuit)).isFalse();
    }

    @DisplayName("다리 건너기 성공한 경우")
    @Test
    void succeedGame() {
        bridgeGame.move(ConstValue.UPPER_BRIDGE);
        bridgeGame.move(ConstValue.LOWER_BRIDGE);
        bridgeGame.move(ConstValue.LOWER_BRIDGE);

        assertThat(bridgeGame.getGameResult()).isEqualTo(ConstValue.SUCCESS);
    }

    @DisplayName("다리 건너기 실패한 경우")
    @Test
    void failedGame() {
        bridgeGame.move(ConstValue.UPPER_BRIDGE);
        bridgeGame.move(ConstValue.LOWER_BRIDGE);

        assertThat(bridgeGame.getGameResult()).isEqualTo(ConstValue.FAIL);
    }

}
