package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest extends ApplicationTest {

    @DisplayName("사용자 칸 이동 테스트 1")
    @Test
    void move() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "D", "D", "U", "D", "U");
            assertThat(output()).contains(
                    "[   |   | O |   | O ]",
                    "[ O | O |   | O |   ]"
            );
            int upSideIndex = output().indexOf("[   |   | O |   | O ]");
            int downSideIndex = output().indexOf("[ O | O |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1, 0, 1);
    }

    @DisplayName("사용자 칸 이동 테스트 2")
    @Test
    void move2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "R", "D", "D", "D");
            assertThat(output()).contains(
                    "[   |   |   ]",
                    "[ O | O | O ]"
            );
            int upSideIndex = output().indexOf("[   |   |   ]");
            int downSideIndex = output().indexOf("[ O | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 0, 0, 0);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(List.of(" O |   ", "  | X ")),
                Arguments.of(List.of(" O | O |  ", "  |  | X ")),
                Arguments.of(List.of(" X ", "  "))
        );
    }

    @ParameterizedTest
    @MethodSource("parameterProvider")
    void isFailure(List<String> upSideDownSideMove) {
        BridgeGame bridgeGame = new BridgeGame();
        boolean actual = bridgeGame.isFailure(upSideDownSideMove);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @DisplayName("총 시도한 횟수 테스트")
    @Test
    void retry() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "R", "D", "D", "U", "R", "D", "D", "D");
            assertThat(output()).contains(
                    "[   |   |   ]",
                    "[ O | O | O ]"
            );
            assertThat(output()).contains("3");
        }, 0, 0, 0, 0, 0, 0, 0, 0);
    }
}