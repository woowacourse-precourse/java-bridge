package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("가장 최근의 움직임 구하기")
    @Nested
    class GetLatestMovingTest {

        @DisplayName("위로 움직인 경우")
        @Test
        void moveUp() {
            Player player = new Player();

            player.move("U");

            String latestMoving = player.getLatestMoving();
            assertThat(latestMoving).isEqualTo("U");
        }

        @DisplayName("움직이지 않은경우 호출하면 에러가 발생해야 한다.")
        @Test
        void nonMove() {
            Player player = new Player();

            assertThatThrownBy(player::getLatestMoving)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage("아직 이동하지 않았습니다. 한번 이상은 이동 해야 합니다.");
        }
    }

    @DisplayName("위치 구하기")
    @Nested
    class GetPositionTest {

        @DisplayName("한번 움직인 경우")
        @Test
        void moveUp() {
            Player player = new Player();

            player.move("U");

            int position = player.getPosition();
            assertThat(position).isEqualTo(0);
        }

        @DisplayName("안 움직인 경우")
        @Test
        void nonMove() {
            Player player = new Player();

            int position = player.getPosition();
            assertThat(position).isEqualTo(-1);
        }
    }

    @DisplayName("위치 구하기")
    @Nested
    class ResetTest {

        @DisplayName("위치값이 -1이 되어야 한다.")
        @Test
        void reset() {
            Player player = new Player();
            player.move("U");

            player.reset();

            int position = player.getPosition();
            assertThat(position).isEqualTo(-1);
        }
    }
}