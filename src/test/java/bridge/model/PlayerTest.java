package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("처음 생성된 플레이어의 시도 횟수는 1이다.")
    @Test
    void initAttempt() {
        //given
        Player player = new Player();

        //when
        int attempt = player.getAttempt();

        //then
        assertThat(attempt).isEqualTo(1);
    }

    @DisplayName("플레이어의 시도 횟수가 증가한다.")
    @Test
    void increaseAttempt() {
        //given
        Player player = new Player();

        //when
        player.attempt();
        int attempt = player.getAttempt();

        //then
        assertThat(attempt).isEqualTo(2);
    }

    @DisplayName("플레이어의 시도 횟수가 증가하면 방향이 초기화된다.")
    @Test
    void increaseAttemptWithClear() {
        //given
        Player player = new Player();

        //when
        player.move(Direction.UP);
        player.attempt();
        int attempt = player.getAttempt();

        //then
        assertThat(attempt).isEqualTo(2);
        assertThat(player.getDirections()).isEmpty();
    }

    @DisplayName("처음 생성된 플레이어는 이동 방향을 가지고 있지 않다.")
    @Test
    void initDirections() {
        //given
        Player player = new Player();

        //when
        List<String> directions = player.getDirections();

        //then
        assertThat(directions).isEmpty();
    }

    @DisplayName("플레이어가 이동한다.")
    @Test
    void move() {
        //given
        Player player = new Player();
        Direction direction = Direction.UP;

        //when
        player.move(direction);
        List<String> directions = player.getDirections();

        //then
        assertThat(directions).isNotEmpty();
        assertThat(directions.size()).isEqualTo(1);
        assertThat(directions).containsExactly(direction.getDirection());
    }

}