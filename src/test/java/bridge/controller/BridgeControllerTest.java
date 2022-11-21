package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.object.Bridge;
import bridge.domain.object.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class BridgeControllerTest {
    @DisplayName("init: 기능이 정상적으로 동작한다")
    @Test
    void init() {
        //given
        BridgeController bridgeController = new BridgeController();

        //when
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BridgeGame game = bridgeController.init();

        //then
        List<String> bridge = game.getBridge().getRoute();
        GameState state = game.getState();
        assertThat(bridge.size()).isEqualTo(4);
        assertThat(state).isEqualTo(GameState.RUN);
    }

    @DisplayName("play: 기능이 정상적으로 동작한다")
    @Test
    void play() {
        //given
        BridgeController bridgeController = new BridgeController();
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame game = new BridgeGame(player, bridge);
        bridgeController.setGame(game);

        //when
        String input = "U\nD\nU";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatCode(bridgeController::play).doesNotThrowAnyException();
    }
}