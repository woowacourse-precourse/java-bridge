package bridge;

import bridge.constant.State;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OutputViewTest {

    ByteArrayOutputStream stream = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(stream));
    }

    @AfterEach
    protected void clear() {
        System.setOut(System.out);
        stream.reset();
    }

    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("위 위 위",
                new Result(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U"), 3,
                    State.Win),
                "[ O | O | O ]\n[   |   |   ]\n"),
            Arguments.of("위 위 아래",
                new Result(Arrays.asList("U", "U", "D"), Arrays.asList("U", "U", "D"), 3,
                    State.Win),
                "[ O | O |   ]\n[   |   | O ]\n"),
            Arguments.of("위 위 아래(불가능)",
                new Result(Arrays.asList("U", "U", "D"), Arrays.asList("U", "U", "U"), 3,
                    State.Loss),
                "[ O | O |   ]\n[   |   | X ]\n"),
            Arguments.of("위 위 위(불가능)",
                new Result(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "D"), 3,
                    State.Loss),
                "[ O | O | X ]\n[   |   |   ]\n"),
            Arguments.of("위",
                new Result(Arrays.asList("U"), Arrays.asList("U", "U", "D"), 3, State.Loss),
                "[ O ]\n[   ]\n"),
            Arguments.of("위",
                new Result(Arrays.asList("D"), Arrays.asList("U", "U", "D"), 3, State.Loss),
                "[   ]\n[ X ]\n")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("올바르게 다리 상태를 출력해주는지 테스트")
    void test1(String description, Result result, String expect) {
        OutputView view = new OutputView();
        view.printMap(result);
        Assertions.assertEquals(expect, stream.toString());
    }

    private static Collection<Arguments> param2() {
        return Arrays.asList(
            Arguments.of("1번에 성공",
                new Result(Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U"),
                    1, State.Win), "최종 게임 결과\n"
                    + "[ O | O | O ]\n"
                    + "[   |   |   ]\n"
                    + "\n"
                    + "게임 성공 여부: 성공\n"
                    + "총 시도한 횟수: 1\n"),
            Arguments.of("1번에 실패",
                new Result(Arrays.asList("U", "U", "D"), Arrays.asList("U", "U", "U"),
                    1, State.Loss), "최종 게임 결과\n"
                    + "[ O | O |   ]\n"
                    + "[   |   | X ]\n"
                    + "\n"
                    + "게임 성공 여부: 실패\n"
                    + "총 시도한 횟수: 1\n"),
            Arguments.of("1번에 실패", new Result(Arrays.asList("D"), Arrays.asList("U", "U", "U"),
                1, State.Loss), "최종 게임 결과\n"
                + "[   ]\n"
                + "[ X ]\n"
                + "\n"
                + "게임 성공 여부: 실패\n"
                + "총 시도한 횟수: 1\n")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    @DisplayName("최종 결과 출력 테스트")
    void test2(String description, Result result, String expect) {
        OutputView view = new OutputView();
        view.printResult(result);
        Assertions.assertEquals(expect, stream.toString());
    }

}
