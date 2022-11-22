package bridge.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {
    @Test
    void 사용자_칸_이동_테스트_성공반환(){
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.setUserMoving("U");
        int step = 0;
        boolean isEqual = bridgeGame.move(step);
        assertThat(isEqual).isEqualTo(true);
        assertThat(bridgeGame.getUserThinkBridge()).containsExactly("O");
    }

    @Test
    void 사용자_칸_이동_테스트_실패반환(){
        Bridge bridge = new Bridge(newArrayList("U", "D", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.setUserMoving("D");
        int step = 0;
        boolean isEqual = bridgeGame.move(step);
        assertThat(isEqual).isEqualTo(false);
        assertThat(bridgeGame.getUserThinkBridge()).containsExactly("X");
    }

    @Test
    void 주어진_다리_마지막과_유저_생각_비교_테스트_실패(){
        Bridge bridge = new Bridge(newArrayList("U", "U", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.setUserMoving("U");
        bridgeGame.move(0);
        bridgeGame.move(1);
        bridgeGame.move(2);
        bridgeGame.move(3);

        boolean isEqual = bridgeGame.compareLastBridgeAndUserThink();
        assertThat(isEqual).isEqualTo(false);
    }

    @Test
    void 주어진_다리_마지막과_유저_생각_비교_테스트_성공(){
        Bridge bridge = new Bridge(newArrayList("U", "U", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.setUserMoving("U");
        bridgeGame.move(0);
        bridgeGame.move(1);
        bridgeGame.move(2);

        boolean isEqual = bridgeGame.compareLastBridgeAndUserThink();
        assertThat(isEqual).isEqualTo(true);
    }

    @Test
    void 재시작_테스트(){
        Bridge bridge = new Bridge(newArrayList("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.setUserMoving("U");
        bridgeGame.move(0);
        bridgeGame.move(1);

        assertThat(bridgeGame.getUserThinkBridge()).containsExactly("O", "X");
        bridgeGame.retry();
        assertThat(bridgeGame.getUserThinkBridge()).isEmpty();
    }
}