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
        bridgeGame.initBridge(bridge);
    }

    @DisplayName("건널 수 있을 경우")
    @Test
    void movable() {
        for (String moving : bridge) {
            Assertions.assertThat(bridgeGame.move(moving)).isTrue();
        }
    }

    @DisplayName("건널 수 없을 경우")
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


    @DisplayName("다리 초기화")
    @Test
    void initBridge() {
        List<String> newBridge = bridgeMaker.makeBridge(8);
        bridgeGame.initBridge(newBridge);

        Assertions.assertThat(newBridge).isEqualTo(bridgeGame.getBridge());
        Assertions.assertThat(bridgeGame.getGameCount()).isEqualTo(1);
        Assertions.assertThat(bridgeGame.getUserRoute()).isEqualTo(new ArrayList<>());
    }


    @DisplayName("게임 재실행")
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