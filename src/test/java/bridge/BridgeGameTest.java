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

import java.io.*;
import java.util.List;

class BridgeGameTest {
    Bridge bridge;
    Result result = new Result();
    InputController inputController = new InputController();
    BridgeGame bridgeGame = new BridgeGame(bridge, result, inputController);
    Player player = new Player();


    @DisplayName("길이가 3인 브릿지 객체를 생성하고 플레이어는 두번 연속 다리 건너기에 성공함")
    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U"));
        bridge.getBridgeSize();
        // player.updateMovement(Movement.UP);
        // player.updateMovement(Movement.DOWN);

    }

    @DisplayName("Player 객체의 경로 객체(MOVEMENT)가 정상적으로 업데이트 됨")
    @Test
    void getRoute() {
        assertThat(player.getRoute()).isEqualTo(List.of(Movement.UP, Movement.DOWN));
    }


    @DisplayName("플레이어가 추가적으로 다리를 한번 건넜고 결과는 성공함")
    @Test
    void movePlayer() {
        String input = "U";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bridgeGame.move();

        assertThat(player.getRoute()).isEqualTo(List.of(Movement.UP));

    }

}