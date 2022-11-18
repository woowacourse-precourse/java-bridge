package bridge.domain.operator;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.bridge.Bridge;
import bridge.domain.player.Player;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("플레이어가 선택한 칸으로 이동시키고 이동 결과를 저장한다.")
    void moveTest() {
        //given
        Bridge bridge = new Bridge(List.of("0", "0","1"));
        BridgeGame bridgeGame = new BridgeGame(bridge, new Player());

        String playerSelection1 = "D";
        String playerSelection2 = "U";

        //when
        bridgeGame.move(playerSelection1);
        bridgeGame.move(playerSelection2);

        //then
        List<Boolean> upBridgeResult = bridgeGame.getUpBridgeResult();
        List<Boolean> downBridgeResult = bridgeGame.getDownBridgeResult();

        assertThat(upBridgeResult.get(0)).isEqualTo(null);
        assertThat(upBridgeResult.get(1)).isEqualTo(false);
        assertThat(downBridgeResult.get(0)).isEqualTo(true);
        assertThat(downBridgeResult.get(1)).isEqualTo(null);
    }

}
