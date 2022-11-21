package bridge;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.controller.InputController;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class BridgeGameTest {
    Bridge bridge;
    Player player;
    InputController inputController;
    BridgeGame bridgeGame;
    Result result;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U"));
        player = new Player();
        inputController = new InputController();
        player.updateMovement(Movement.UP);
        player.updateMovement(Movement.DOWN);
        player.updateMovement(Movement.UP);
        bridgeGame = new BridgeGame(bridge,result, inputController);
    }

}