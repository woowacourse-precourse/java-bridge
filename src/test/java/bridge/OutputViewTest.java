package bridge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
            Arguments.of("위 위 위", Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "U"),
                "[ O | O | O ]\n[   |   |   ]\n"),
            Arguments.of("위 위 아래", Arrays.asList("U", "U", "D"), Arrays.asList("U", "U", "D"),
                "[ O | O |   ]\n[   |   | O ]\n"),
            Arguments.of("위 위 아래(불가능)", Arrays.asList("U", "U", "D"), Arrays.asList("U", "U", "U"),
                "[ O | O |   ]\n[   |   | X ]\n"),
            Arguments.of("위 위 위(불가능)", Arrays.asList("U", "U", "U"), Arrays.asList("U", "U", "D"),
                "[ O | O | X ]\n[   |   |   ]\n"),
            Arguments.of("위", Arrays.asList("U"), Arrays.asList("U", "U", "D"),
                "[ O ]\n[   ]\n"),
            Arguments.of("위", Arrays.asList("D"), Arrays.asList("U", "U", "D"),
                "[   ]\n[ X ]\n")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("올바르게 다리 상태를 출력해주는지 테스트")
    void test1(String description, List<String> input, List<String> answer, String expect) {
        OutputView view = new OutputView();
        view.printMap(input, answer);
        Assertions.assertEquals(expect, stream.toString());
    }
}
