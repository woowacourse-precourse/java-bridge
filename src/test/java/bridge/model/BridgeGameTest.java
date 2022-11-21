package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Bridgelocation;
import bridge.model.MoveBox;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void move_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("U", "U");
        assertThat(bridgeGame.getResult().get(0)).isEqualTo(Bridgelocation.UPO.getBridge());
    }

    @Test
    void move_예외_테스트() {
        assertThatThrownBy(() -> new BridgeGame().move("x", "U")).isInstanceOf(
            IllegalArgumentException.class);
    }

}
