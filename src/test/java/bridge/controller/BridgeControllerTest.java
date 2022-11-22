package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.object.Bridge;
import bridge.domain.object.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class BridgeControllerTest {
    private static BridgeController bridgeController;

    @BeforeAll
    static void setBridgeController() {
        bridgeController = new BridgeController();
    }

    @DisplayName("init: 기능이 정상적으로 동작한다")
    @Test
    void init() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BridgeGame game = bridgeController.init();

        List<String> bridge = game.getBridge().getRoute();
        GameState state = game.getState();

        assertThat(bridge.size()).isEqualTo(4);
        assertThat(state).isEqualTo(GameState.RUN);
    }

    @DisplayName("play: 기능이 정상적으로 동작한다")
    @Test
    void play() {
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame game = new BridgeGame(player, bridge);
        bridgeController.setGame(game);

        String input = "U\nD\nU";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatCode(bridgeController::play).doesNotThrowAnyException();
    }

    @DisplayName("choiceRestartOrQuit: 게임 실패시 R을 입력할 경우 재시작한다.")
    @Test
    void retry() {
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame game = new BridgeGame(player, bridge);
        bridgeController.setGame(game);

        String input = "U\nD\nD\nR\nU\nD\nU";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatCode(bridgeController::play).doesNotThrowAnyException();
    }
}