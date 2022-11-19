package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void initBridgeGame() {
        bridgeGame = new BridgeGame();
    }

    @Test
    @DisplayName("게임 초기화 시 다리 정보가 제대로 들어가는지 확인하는 테스트")
    void initGameBridgeTest() {
        List<String> tempList = List.of("U", "D");
        bridgeGame.initGame(tempList);

        Assertions.assertThat(bridgeGame.getBridge()).isEqualTo(tempList);
    }

    @Test
    @DisplayName("게임 초기화 시 현재 위치가 되는지 확인하는 테스트")
    void initGameCurStepTest() {
        bridgeGame.initGame(List.of("U", "D"));
        int firstStep = 0;

        Assertions.assertThat(bridgeGame.getUserMoving().size()).isEqualTo(firstStep);
    }

    @Test
    @DisplayName("다음 다리를 맞췄을 경우 true를 반환해야 한다")
    void moveCorrectTest() {
        bridgeGame.initGame(List.of("U", "D", "D"));

        Assertions.assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @Test
    @DisplayName("다음 다리를 틀렸을 경우 false를 반환해야 한다")
    void moveIncorrectTest() {
        bridgeGame.initGame(List.of("U", "D", "D"));

        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(false);
    }

    @Test
    @DisplayName("재시작을 한다고 할 경우 true를 반환해야 한다.")
    void retryCorrectTest() {
        Assertions.assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }

    @Test
    @DisplayName("다음 다리를 틀렸을 경우")
    void retryIncorrectTest() {
        Assertions.assertThat(bridgeGame.retry("D")).isEqualTo(false);
    }

    @Test
    @DisplayName("게임이 끝났을 경우 true를 반환해야 한다.")
    void checkFinishedTest() {
        bridgeGame.initGame(List.of("U", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");

        Assertions.assertThat(bridgeGame.isFinished()).isEqualTo(true);
    }

    @Test
    @DisplayName("게임이 안 끝났을 경우 false를 반환해야 한다.")
    void checkNotFinishedTest() {
        bridgeGame.initGame(List.of("U", "D"));
        bridgeGame.move("U");

        Assertions.assertThat(bridgeGame.isFinished()).isEqualTo(false);
    }
}