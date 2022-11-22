package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.State;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {

    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("3번 이동 후 도착", List.of("D", "D", "D"), List.of("D", "D", "D")),
            Arguments.of("10번 이동 후 도착", List.of("D", "D", "D", "D", "D", "D", "D", "D", "D", "D"),
                List.of("D", "D", "D", "D", "D", "D", "D", "D", "D", "D"))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("다리 게임에서 성공하는 케이스 테스트")
    void test1(String description, List<String> answer, List<String> directions) {
        BridgeGame game = new BridgeGame(answer);
        directions.forEach(i -> game.move(i));
        Result result = game.getResult();
        Assertions.assertEquals(State.Win, result.getState());
    }

    private static Collection<Arguments> param2() {
        return Arrays.asList(
            Arguments.of("3번 이동 후 실패", List.of("D", "D", "U"), List.of("D", "D", "D")),
            Arguments.of("5번 이동 후 실패", List.of("D", "D", "U", "U", "D"),
                List.of("D", "D", "U", "U", "U")),
            Arguments.of("10번 이동 후 실패", List.of("D", "D", "D", "D", "D", "D", "D", "D", "D", "U"),
                List.of("D", "D", "D", "D", "D", "D", "D", "D", "D", "D"))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    @DisplayName("다리 게임에서 실패하는 케이스 테스트")
    void test2(String description, List<String> answer, List<String> directions) {
        BridgeGame game = new BridgeGame(answer);
        directions.forEach(i -> game.move(i));
        Result result = game.getResult();
        Assertions.assertEquals(State.Loss, result.getState());
    }

    private static Collection<Arguments> param3() {
        return Arrays.asList(
            Arguments.of("3번 이동 후 게임중", List.of("D", "D", "U"), List.of("D", "D")),
            Arguments.of("5번 이동 후 게임중", List.of("D", "D", "U", "U", "D"),
                List.of("D", "D", "U", "U")),
            Arguments.of("10번 이동 후 게임중", List.of("D", "D", "D", "D", "D", "D", "D", "D", "D", "U"),
                List.of("D", "D", "D", "D", "D", "D", "D", "D", "D"))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param3")
    @DisplayName("다리 게임에서 아직 게임중인 케이스 테스트")
    void test3(String description, List<String> answer, List<String> directions) {
        BridgeGame game = new BridgeGame(answer);
        directions.forEach(i -> game.move(i));
        Result result = game.getResult();
        Assertions.assertEquals(State.Progress, result.getState());
    }

    private static Collection<Arguments> param4() {
        return Arrays.asList(
            Arguments.of("3번째 이동에 익셉션", List.of("D", "D", "D"), List.of("D", "D", "A")),
            Arguments.of("3번째 이동에 익셉션", List.of("U", "D", "D"), List.of("T", "D", "U")),
            Arguments.of("3번째 이동에 익셉션", List.of("D", "D", "D"), List.of("1"))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param4")
    @DisplayName("이상한 방향으로 움직이면 익셉션")
    void test4(String description, List<String> answer, List<String> directions) {
        BridgeGame game = new BridgeGame(answer);
        assertThatThrownBy(() -> directions.forEach(i -> game.move(i))).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("게임 재시작시 시도 횟수가 증가하는지 테스트")
    void test5() {
        BridgeGame game = new BridgeGame(List.of("D", "D", "D"));
        Result result = game.getResult();
        Assertions.assertEquals(1, result.getTime());
        game.retry();
        result = game.getResult();
        Assertions.assertEquals(2, result.getTime());
    }
}
