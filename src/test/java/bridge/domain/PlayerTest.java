package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

    @DisplayName("정답이 U일 때 정답/오답을 입력한 경우 각각 게임 성공 여부 true/false")
    @MethodSource("ProvideAnswer")
    @ParameterizedTest
    void testAliveWhenTakeRightOrWrongAnswers(String command, boolean expected) {
        Player player = new Player(new Map());
        player.move(command, "U");
        assertEquals(expected, player.isAlive());
    }

    private static Stream<Arguments> ProvideAnswer() {
        return Stream.of(
                Arguments.of("U", true),
                Arguments.of("D", false)
        );
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