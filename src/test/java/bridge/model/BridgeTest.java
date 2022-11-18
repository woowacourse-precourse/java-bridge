package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @DisplayName("플레이어의 방향 개수가 다리 길이와 같다면 예외가 발생한다.")
    @Test
    void validatePlayerStatus1() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        Player player = new Player();

        //when
        player.move(Direction.UP);
        player.move(Direction.DOWN);

        //then
        assertThatThrownBy(() -> bridge.validatePlayerStatus(player))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("플레이어의 방향 개수가 다리 길이보다 크다면 예외가 발생한다.")
    @Test
    void validatePlayerStatus2() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        Player player = new Player();

        //when
        player.move(Direction.UP);
        player.move(Direction.DOWN);
        player.move(Direction.DOWN);

        //then
        assertThatThrownBy(() -> bridge.validatePlayerStatus(player))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("플레이어의 방향 중 다리와 일치하지 않는 것이 존재하면 예외가 발생한다.")
    @Test
    void validatePlayerStatus3() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D"));
        Player player = new Player();

        //when
        player.move(Direction.DOWN);

        //then
        assertThatThrownBy(() -> bridge.validatePlayerStatus(player))
                .isInstanceOf(IllegalStateException.class);
    }

}