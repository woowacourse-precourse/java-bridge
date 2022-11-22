package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayName("Player 클래스")
public class PlayerTest {

    @Nested
    @DisplayName("플레이어의 상태는")
    class Describe_status {

        //given
        Player player = new Player();

        @Test
        @DisplayName("처음 생성되었을 때는 ALIVE 이다.")
        void player_alive() {
            assertThat(player.isAlive()).isTrue();
        }

        @Test
        @DisplayName("죽은 후에는 DEAD 이다.")
        void player_die() {
            //when
            player.die();
            //then
            assertThat(player.isDead()).isTrue();
        }
    }

    @Nested
    @DisplayName("move 메소드는")
    class Describe_move {

        Player player = new Player();

        @Test
        @DisplayName("이동 후 위치가 변화한다.")
        void 플레이어_이동_테스트() {
            int currentLocation = player.getCurrentLocation();
            //when
            player.move();
            int moveLocation = player.getCurrentLocation();
            //then
            assertThat(currentLocation).isNotEqualTo(moveLocation);
        }

        @Test
        @DisplayName("죽었을 때 이동하면 예외가 발생한다.")
        void 플레이어_사망_이동_테스트() {
            //when
            player.die();
            //then
            Assertions.assertThatThrownBy(player::move)
                .isInstanceOf(IllegalStateException.class);
        }
    }
}
