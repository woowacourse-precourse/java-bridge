package bridge;

import bridge.enums.BridgeMove;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;


class BridgeGameTest extends NsTest {

    @DisplayName("다리를 생성한다.")
    @Test
    void generateBridge() {
        //given
        BridgeGame game = new BridgeGame(Arrays.asList("D", "D", "U", "D"));
        //when
        Bridges bridges = game.getGameBridges();
        //then
        assertThat(bridges).isEqualTo(new Bridges(Arrays.asList("D", "D", "U", "D")));
    }

    @Test
    void play() {
        assertSimpleTest(() -> {
            run("U");
            assertThat(output()).contains("[ X ]");
        });
    }

    @DisplayName("move()에서 입력된 U,D으로 bridge를 정상적으로 건너는 지 확인")
    @Test
    void move() {
        //given
        BridgeGame game = new BridgeGame(Arrays.asList("D", "D", "U", "D"));
        //when
        game.move("D");
        game.move("D");
        //then
        Bridges bridges = game.getGameBridges();
        assertThat(bridges.getPlayerMoves()).isEqualTo(Arrays.asList(BridgeMove.getEnum("D"), BridgeMove.getEnum("D")));
    }

    @Override
    protected void runMain() {
        //given
        BridgeGame game = new BridgeGame(Arrays.asList("D", "D", "U", "D"));
        game.play();
    }
}