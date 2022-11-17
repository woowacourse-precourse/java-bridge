package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("해당 위치가 다리 길이를 벗어나면 예외가 발생한다.")
    @Test
    void outOfIndex() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        int index = 2;
        String direction = "D";

        //then
        assertThatThrownBy(() -> bridge.validateDirection(index, direction))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("해당 위치의 방향이 올바르지 않으면 예외가 발생한다.")
    @Test
    void validateDirection() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        int index = 0;
        String direction = "D";

        //then
        assertThatThrownBy(() -> bridge.validateDirection(index, direction))
                .isInstanceOf(IllegalStateException.class);
    }

}