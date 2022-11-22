package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {
    BridgeGame bridgeGame;
    @BeforeEach
    void init(){
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(3));
    }

    @Test
    @DisplayName("브릿지 게임 이동 성공")
    void moveSuccess() {
        Assertions.assertThat(bridgeGame.move("U")).isEqualTo(true);
    }

    @Test
    @DisplayName("브릿지 게임 이동 성공")
    void moveFail() {
        Assertions.assertThat(bridgeGame.move("D")).isEqualTo(false);
    }

    @Test
    @DisplayName("브릿지 게임 이동 횟수 초과 예외")
    void moveException() {
        Assertions.assertThatThrownBy(() -> {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            bridgeGame.move("D");
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("브릿지 게임 재시작 성공")
    void retrySuccess() {
        Assertions.assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }

    @Test
    @DisplayName("브릿지 게임 종료 성공")
    void exitSuccess() {
        Assertions.assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }
}