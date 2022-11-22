package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @DisplayName("이동 명령어로 소문자를 입력했을 때 예외 발생")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void testLower(String command) {
        assertThatThrownBy(() -> {
            Player player = new Player(new Map());
            player.move(command.toLowerCase(), command);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class AliveTest {
        @DisplayName("정답 입력")
        @Test
        void right3Wrong1() {
            Player player = new Player(new Map());
            player.move("U", "U");
            assertThat(player.isAlive()).isEqualTo(true);
        }

        @DisplayName("오답 입력")
        @Test
        void right4() {
            Player player = new Player(new Map());
            player.move("U", "D");
            assertThat(player.isAlive()).isEqualTo(false);
        }
    }

    @Nested
    class SucceedTest {
        private List<String> bridge = newArrayList("U", "U", "D");

        @DisplayName("최종 정답")
        @Test
        void right() {
            Player player = new Player(new Map());
            player.move("U", "U");
            player.move("U", "U");
            player.move("D", "D");

            assertThat(player.hasSucceeded(bridge)).isEqualTo(true);
        }

        @DisplayName("최종 오답: 끝까지 가지 전에 탈락")
        @Test
        void wrong1() {
            Player player = new Player(new Map());
            player.move("U", "U");
            player.move("U", "D");
            assertThat(player.hasSucceeded(bridge)).isEqualTo(false);
        }

        @DisplayName("최종 오답: 끝까지 가서 탈락")
        @Test
        void wrong2() {
            Player player = new Player(new Map());
            player.move("U", "U");
            player.move("U", "U");
            player.move("U", "D");
            assertThat(player.hasSucceeded(bridge)).isEqualTo(false);
        }
    }
}