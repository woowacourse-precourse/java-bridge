package bridge;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame game;

    @BeforeEach
    void init() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        game = new BridgeGame();
        game.initBridge(bridgeMaker.makeBridge(3));
    }

    @DisplayName("move() 메서드 동작 테스트")
    @Test
    void move() {
        game.move(BridgeGame.CMD_UP);
        Assertions.assertThat(game.getLastPosition()).isEqualTo(1);
        Assertions.assertThat(game.getLastCommand()).isEqualTo(BridgeGame.CMD_UP);
    }

    @DisplayName("재시작 메서드 동작 테스트")
    @Test
    void retry() {
        game.retry();
        Assertions.assertThat(game.getTryCount()).isEqualTo(2);
        game.retry();
        Assertions.assertThat(game.getTryCount()).isEqualTo(3);
    }

    @DisplayName("플레이어 생존 확인 메서드 동작 테스트")
    @Test
    void isPlayerAlive() {
        Assertions.assertThat(game.isPlayerAlive()).isEqualTo(true);
        game.move(BridgeGame.CMD_DOWN);
        Assertions.assertThat(game.isPlayerAlive()).isEqualTo(false);
    }

    @DisplayName("플레이어 승리 확인 메서드 (성공) 동작 테스트")
    @Test
    void isSuccess_true() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_DOWN);
        Assertions.assertThat(game.isSuccess()).isEqualTo(true);
    }

    @DisplayName("플레이어 성공 확인 메서드 (실패) 동작 테스트")
    @Test
    void isSuccess_false() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_UP);
        Assertions.assertThat(game.isSuccess()).isEqualTo(false);
    }

    @DisplayName("결과값 문자열 변환 메서드 (성공) 동작 테스트")
    @Test
    void getGameResultToString_success() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_DOWN);
        Assertions.assertThat(game.getGameResultToString()).isEqualTo("성공");
    }

    @DisplayName("결과값 문자열 변환 메서드 (실패) 동작 테스트")
    @Test
    void getGameResultToString_failed() {
        game.move(BridgeGame.CMD_UP);
        game.move(BridgeGame.CMD_DOWN);
        game.move(BridgeGame.CMD_UP);
        Assertions.assertThat(game.getGameResultToString()).isEqualTo("실패");
    }
}