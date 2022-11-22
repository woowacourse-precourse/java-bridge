package bridge;

import bridge.enums.BridgeMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("다리를 생성한다.")
    @Test
    void generateBridge() {
        //given
        BridgeGame game = new BridgeGame(Arrays.asList("D", "D", "U", "D"));
        //when
        Bridges bridges = game.getGameBridges();
        //then
        assertThat(bridges.getBridges()).isEqualTo(new Bridges(Arrays.asList("D", "D", "U", "D")).getBridges());
    }

    @DisplayName("move()에서 입력된 U,D으로 bridge를 정상적으로 건너는 지 확인")
    @Test
    void move() {
        //given
        BridgeGame game = new BridgeGame(Arrays.asList("D", "D", "U", "D"));
        //when
        game.move(BridgeMove.getEnum("D"));
        game.move(BridgeMove.getEnum("D"));
        //then
        Bridges bridges = game.getGameBridges();
        assertThat(bridges.getPlayerMoves()).isEqualTo(Arrays.asList(BridgeMove.getEnum("D"), BridgeMove.getEnum("D")));
    }
}