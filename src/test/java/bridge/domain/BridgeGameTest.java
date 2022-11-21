package bridge.domain;

import bridge.domain.object.Bridge;
import bridge.domain.object.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.controller.GameState.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    @DisplayName("플레이어를 이동시킨다.")
    @Test
    void move() {
        //given
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame game = new BridgeGame(player, bridge);

        //when
        game.move("U");

        //then
        assertThat(game.getPlayer().getMoves().get(0)).isEqualTo("U");
    }

    @DisplayName("현재까지의 이동 경로가 맞다면 RUN 이 반환된다.")
    @Test
    void checkRun() {
        //given
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame game = new BridgeGame(player, bridge);

        //when
        game.move("U");

        //then
        assertThat(game.checkGameState()).isEqualTo(RUN);
    }

    @DisplayName("현재까지의 이동 경로가 다르다면 FAIL 이 반환된다.")
    @Test
    void checkFail() {
        //given
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame game = new BridgeGame(player, bridge);

        //when
        game.move("D");

        //then
        assertThat(game.checkGameState()).isEqualTo(FAIL);
    }

    @DisplayName("다리를 전부 건넜다면 CLEAR 가 반환된다.")
    @Test
    void checkClear() {
        //given
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame game = new BridgeGame(player, bridge);

        //when
        game.move("U");
        game.move("D");
        game.move("U");

        //then
        assertThat(game.checkGameState()).isEqualTo(CLEAR);
    }
}