package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("플레이어가 이동할 수 있으면 true 반환한다.")
    @Test
    void canMove() {
        //given
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D"));

        //when
        boolean result = bridge.canMove(player);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("플레이어가 이동할 수 없으면 false 반환한다.")
    @Test
    void cannotMove() {
        //given
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D"));

        //when
        player.move(Direction.UP);
        player.move(Direction.DOWN);
        boolean result = bridge.canMove(player);

        //then
        assertThat(result).isFalse();
    }

}