package bridge.domain;

import bridge.type.PositionType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void 플에이어는_이동칸을_선택한다() {
        // given
        Player player = new Player();

        PositionType up = PositionType.UP;
        PositionType down = PositionType.DOWN;

        // when
        player.selectPosition(up.getPositionSymbol());
        player.selectPosition(up.getPositionSymbol());
        player.selectPosition(down.getPositionSymbol());

        // then
        PositionType firstSelected = player.currentPosition(0);
        PositionType secondSelected = player.currentPosition(1);
        PositionType thirdSelected = player.currentPosition(2);

        assertThat(firstSelected).isEqualTo(up);
        assertThat(secondSelected).isEqualTo(up);
        assertThat(thirdSelected).isEqualTo(down);
    }
}