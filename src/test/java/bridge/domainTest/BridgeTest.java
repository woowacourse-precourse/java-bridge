package bridge.domainTest;
import bridge.model.Bridge;
import bridge.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    Bridge bridge;

    @BeforeEach
    void initializeClass(){
        bridge = new Bridge(List.of("U", "D", "U"));
    }

    @DisplayName("플레이어의 다리가 Bridge의 다리에 포함될 경우 참을 반환")
    @Test
    void isPlayerRightBridgeTest(){
        Player player = new Player();
        player.addNewBridgeInput("U");
        assertThat(bridge.isPlayerRightBridge(player)).isTrue();
    }

    @DisplayName("반환값은 생성자에 넣은 값과 동일하다. ")
    @Test
    void getBridgesTest(){
        assertThat(bridge.getBridges()).isEqualTo(List.of("U", "D", "U"));
    }
}
