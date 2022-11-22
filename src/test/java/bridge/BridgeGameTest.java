package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeGameTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();
    List<String> bridge;

    @BeforeEach
    void init() {
        bridge = bridgeMaker.makeBridge(10);
        bridgeGame.init(bridge);
    }

    @DisplayName("해당 칸을 건널 수 있는지 없는지 판단한다. - 성공")
    @Test
    void movable() {
        for (String moving : bridge) {
            Assertions.assertThat(bridgeGame.move(moving)).isTrue();
        }
    }

    @DisplayName("해당 칸을 건널 수 있는지 없는지 판단한다. - 실패")
    @Test
    void unmovable() {
        String moving = bridge.get(0);
        moving = reverseMoving(moving);

        System.out.println(moving);
        Assertions.assertThat(bridgeGame.move(moving)).isFalse();
    }

    private static String reverseMoving(String moving) {
        if (moving.equals("U")) {
            return "D";
        }
        return "U";
    }


    @DisplayName("게임 초기화")
    @Test
    void initGame() {
        List<String> newBridge = bridgeMaker.makeBridge(8);
        bridgeGame.init(newBridge);

        Assertions.assertThat(newBridge).isEqualTo(bridgeGame.getBridge());
        Assertions.assertThat(bridgeGame.getGameCount()).isEqualTo(1);
        Assertions.assertThat(bridgeGame.getUserRoute()).isEqualTo(new ArrayList<>());
    }


    @DisplayName("재시작할 경우 전에 만든 다리를 활용한다.")
    @Test
    void retry() {
        bridgeGame.move("U");
        int gameCount = bridgeGame.getGameCount();

        // 재실행 시
        bridgeGame.retry();
        Assertions.assertThat(bridgeGame.getGameCount()).isEqualTo(gameCount + 1);
        Assertions.assertThat(bridgeGame.getUserRoute().size()).isEqualTo(0);
    }

}