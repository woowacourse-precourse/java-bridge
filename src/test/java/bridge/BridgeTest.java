package bridge;

import bridge.model.Bridge;
import bridge.model.User;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest extends NsTest {
    @Test
    void moveTest(){
        Bridge bridge =new Bridge(newArrayList("U","U","D"));
        User user =new User();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(bridge,user,"U");
        assertThat(user.getPosition()).isEqualTo(1);
        bridgeGame.move(bridge,user,"D");
        assertThat(user.getResult()).isFalse();
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
