package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    private static Stream<Arguments> provideAnswer() {
        return Stream.of(
                Arguments.of("U", true),
                Arguments.of("D", false)
        );
    }

    private static Stream<Arguments> provideSucceedArguments() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "D"), List.of("U", "U", "D"), true, "최종 정답"),
                Arguments.of(List.of("U", "D"), List.of("U", "U"), false, "다리 끝에 도달 전에 오답"),
                Arguments.of(List.of("U", "U", "D"), List.of("U", "U", "U"), false, "다리 끝에서 오답")
        );
    }

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
    @MethodSource("provideAnswer")
    @ParameterizedTest
    void testAliveWhenTakeRightOrWrongAnswers(String command, boolean expected) {
        Player player = new Player(new Map());
        player.move(command, "U");
        assertEquals(expected, player.isAlive());
    }

    @DisplayName("최종 게임 승리 여부 검사")
    @MethodSource("provideSucceedArguments")
    @ParameterizedTest(name = "{index}: {3}")
    void testSucceed(List<String> bridge, List<String> inputs, boolean expected, String message) {
        Player player = new Player(new Map());
        for (int i = 0; i < bridge.size(); i++) {
            player.move(inputs.get(i), bridge.get(i));
        }
        assertThat(player.hasSucceeded(bridge)).isEqualTo(expected);
    }
}