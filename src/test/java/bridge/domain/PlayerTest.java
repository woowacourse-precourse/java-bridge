package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static bridge.domain.Move.*;
import static bridge.domain.MoveResult.*;
import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    public void playerMoveTest() {
        //given
        Bridge bridge = new Bridge(List.of("U", "U", "D", "U"));
        Player player = new Player();

        //when
        player.move(bridge, UP);
        player.move(bridge, UP);
        player.move(bridge, DOWN);
        player.move(bridge, DOWN);

        //then
        Map<Move, List<MoveResult>> playerMoved = player.getMoveResults();
        assertThat(playerMoved.get(UP))
                .isEqualTo(List.of(SUCCESS, SUCCESS, OTHER, OTHER));
        assertThat(playerMoved.get(DOWN))
                .isEqualTo(List.of(OTHER, OTHER, SUCCESS, FAIL));
    }
}