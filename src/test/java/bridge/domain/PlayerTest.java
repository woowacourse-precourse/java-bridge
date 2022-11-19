package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static bridge.domain.MoveResult.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    public void playerMoveTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D", "U"));
        Player player = new Player();

        //when
        player.move(bridge, "U");
        player.move(bridge, "U");
        player.move(bridge, "D");
        player.move(bridge, "D");

        //then
        Map<Move, List<MoveResult>> playerMoved = player.getMoveResults();
        assertThat(playerMoved.get(Move.UP))
                .isEqualTo(List.of(SUCCESS, SUCCESS, OTHER, OTHER));
        assertThat(playerMoved.get(Move.DOWN))
                .isEqualTo(List.of(OTHER, OTHER, SUCCESS, FAIL));
    }
}