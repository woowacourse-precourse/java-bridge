package bridge;

import bridge.model.Bridge;
import bridge.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest extends ApplicationTest {
    @Test
    void moveTest(){
        Bridge bridge =new Bridge(newArrayList("U","U","D"));
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setBridge(bridge);
        bridgeGame.move();
        assertThat(bridgeGame.getUser().getPosition()).isEqualTo(1);
        bridgeGame.isCorrect("D");
        bridgeGame.move();
        assertThat(bridgeGame.getUser().getResult()).isFalse();
    }
}
