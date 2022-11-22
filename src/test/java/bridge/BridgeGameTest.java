package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();
    private User user = new User();
    private String moving = "U";
    private List<String> bridge = new ArrayList<>();
    private int size = 1;
    private boolean testResult = false;

    @Test
    void 게임_종료_테스트() {
        bridge.add("U");
        user.setDirection("U");
        bridgeGame.move(user);
        if(bridgeGame.checkBridgeValueInUserPosition(user, bridge) && user.getPosition() == size-1){
            testResult = true;
        }
        assertThat(testResult).isEqualTo(true);
    }
}
