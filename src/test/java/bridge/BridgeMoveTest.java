package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.Bridge;

import bridge.domain.BridgePlayer;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMoveTest {
    private static Bridge bridge;
    private static BridgePlayer player;

    @BeforeAll
    static void initBridge(){
        ArrayList<String> bridgeInfo = new ArrayList<>(List.of("U", "D", "D"));
        bridge = new Bridge(bridgeInfo);
        player = new BridgePlayer();
    }

    @DisplayName("다음칸이 이동할 수 있는 칸인 경우 true 반환")
    @Test
    void caseBridgeMovable(){
        assertThat(bridge.isMoveAble(player.getNextBridgePosition(), "U")).isTrue();
    }

    @DisplayName("다음칸이 이동할 수 없는 칸인 경우 false 반환")
    @Test
    void caseBridgeNotMovable(){
        assertThat(bridge.isMoveAble(player.getNextBridgePosition(), "D")).isFalse();
    }
}
