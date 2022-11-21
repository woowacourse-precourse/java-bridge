package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private Player player;

    @BeforeEach
    void initializePlayer() {
        player = new Player();
    }

    @DisplayName("칸 이동 테스트")
    @Nested
    class MoveTest {
        @DisplayName("이동한 칸에 발판이 있다면 산다 - 위로 이동한 경우")
        @Test
        void case1() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "U");
            assertThat(player.isDead()).isFalse();
        }

        @DisplayName("이동한 칸에 발판이 있다면 산다 - 아래로 이동한 경우")
        @Test
        void case2() {
            Bridge bridge = new Bridge(List.of("D", "U", "D"));
            player.move(bridge, "D");
            assertThat(player.isDead()).isFalse();
        }

        @DisplayName("이동한 칸에 발판이 없으면 죽는다 - 위로 이동한 경우")
        @Test
        void case3() {
            Bridge bridge = new Bridge(List.of("D", "U", "D"));
            player.move(bridge, "U");
            assertThat(player.isDead()).isTrue();
        }

        @DisplayName("이동한 칸에 발판이 없으면 죽는다 - 아래로 이동한 경우")
        @Test
        void case4() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "D");
            assertThat(player.isDead()).isTrue();
        }

        @DisplayName("이미 떨어졌는데 이동하려 하면 예외 처리한다")
        @Test
        void case5() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "D");
            assertThatThrownBy(() -> player.move(bridge, "D"))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @DisplayName("이미 다 건넜는데 추가로 이동하려 하면 예외 처리한다")
        @Test
        void case6() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "U");
            player.move(bridge, "D");
            player.move(bridge, "D");
            assertThatThrownBy(() -> player.move(bridge, "D"))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @DisplayName("도착 확인 테스트")
    @Nested
    class ArriveTest {
        @DisplayName("끝 지점까지 왔고 살아있는 경우 - 도착한 게 맞다")
        @Test
        void case1() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "U");
            player.move(bridge, "D");
            player.move(bridge, "D");
            assertThat(player.isArrived(bridge)).isTrue();
        }

        @DisplayName("잘 가다가 끝 지점에서 죽은 경우 - 도착한 게 아님")
        @Test
        void case2() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "U");
            player.move(bridge, "D");
            player.move(bridge, "U");
            assertThat(player.isArrived(bridge)).isFalse();
        }

        @DisplayName("가는 도중인 경우 - 도착한 게 아님")
        @Test
        void case3() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "U");
            player.move(bridge, "D");
            assertThat(player.isArrived(bridge)).isFalse();
        }

        @DisplayName("가는 도중에 죽은 경우 - 도착한 게 아님")
        @Test
        void case4() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "U");
            player.move(bridge, "U");
            assertThat(player.isArrived(bridge)).isFalse();
        }

        @DisplayName("출발도 안 한 경우 - 도착한 게 아님")
        @Test
        void case5() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            assertThat(player.isArrived(bridge)).isFalse();
        }
    }

    @DisplayName("부활 테스트")
    @Nested
    class ReviveTest {
        @DisplayName("부활하면 살아난다")
        @Test
        void case1() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            player.move(bridge, "D");

            player.reVive();

            assertThat(player.isDead()).isFalse();
        }
    }
}
