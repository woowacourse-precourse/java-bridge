package bridge;

import bridge.constant.State;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {

    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("3번 이동 후 성공", List.of("U", "U", "U"),
                new UserInfo(List.of("U", "U", "U"), 3, State.Win),
                "[ O | O | O ]\n", "[   |   |   ]\n"),
            Arguments.of("2번 이동 후 실패", List.of("U", "U", "U"),
                new UserInfo(List.of("U", "D"), 3, State.Loss),
                "[ O |   ]\n", "[   | X ]\n")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("정상적으로 데이터가 들어있는지 테스트")
    void test1(String description, List<String> answer, UserInfo userInfo, String top, String bottom) {
        Result result = new Result(answer, userInfo);
        Assertions.assertEquals(top, result.getTop());
        Assertions.assertEquals(bottom, result.getBottom());
    }

}
