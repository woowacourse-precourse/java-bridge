package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    Bridge bridge;
    Player player;

    @BeforeEach
    void beforeEach() {
        bridge = new Bridge(List.of("U", "D", "U"));
        player = new Player();
    }

    @Test
    void 존재하지_않는_다리로_이동하면_플레이어는_죽어야한다() {
        player.move();
        assertThat(player.die(bridge, Direction.DOWN)).isEqualTo(true);
    }

    @Test
    void 존재하는_다리로_이동하면_플레이어는_죽지_않는다() {
        player.move();
        assertThat(player.die(bridge, Direction.UP)).isEqualTo(false);
    }

    @Test
    void 모든_다리를_통과했으면_성공해야_한다() {
        for (int moveCount = 0; moveCount < 2; moveCount++) {
            player.move();
            assertThat(player.isBridgePassed(bridge)).isEqualTo(false);
        }

        player.move();
        assertThat(player.isBridgePassed(bridge)).isEqualTo(true);
    }

    @Test
    void 재시작을_네번하면_총_시도_횟수는_5번이여야_한다() {
        assertThat(player.getTryCount()).isEqualTo(1);
        for (int restartCount = 0; restartCount < 4; restartCount++) {
            player.initialize();
        }
        assertThat(player.getTryCount()).isEqualTo(5);
    }
}