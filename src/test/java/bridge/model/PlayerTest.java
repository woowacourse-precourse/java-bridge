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
        bridge = new Bridge(List.of("U", "D", "U", "D", "U"));
        player = new Player();
    }

    @Test
    void 존재하지_않는_다리로_이동하면_지도에_X를_그려야한다() {
        MoveResult move = player.move(bridge, Direction.D);
        assertThat(move.getDrawType().getDrawCharacter()).isEqualTo("X");
    }

    @Test
    void 존재하는_다리로_이동하면_지도에_O를_그려야한다() {
        MoveResult move = player.move(bridge, Direction.U);
        assertThat(move.getDrawType().getDrawCharacter()).isEqualTo("O");
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