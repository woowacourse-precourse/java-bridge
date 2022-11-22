package bridge.view.template;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class MovingMapTest {

    @DisplayName("이동한 다리 정보 형식을 변환해 현황 지도에 저장(성공 케이스)")
    @ParameterizedTest
    @MethodSource("generateArgumentStreamForSuccess")
    void addRoundsWithSuccess(String expected, List<String> moving) {
        MovingMap movingMap = new MovingMap();
        moving.forEach(move -> movingMap.addOneRound(false, move));

        assertThat(movingMap.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> generateArgumentStreamForSuccess() {
        List<Arguments> arguments = new LinkedList<>();
        arguments.add(Arguments.of("[ O | O | O ]\n[   |   |   ]", newArrayList("U", "U", "U")));
        arguments.add(Arguments.of("[ O |   | O ]\n[   | O |   ]", newArrayList("U", "D", "U")));
        arguments.add(Arguments.of(
                "[ O |   | O | O |   | O | O |   | O | O |   | O | O |   | O |   |   ]\n" +
                "[   | O |   |   | O |   |   | O |   |   | O |   |   | O |   | O | O ]",
                newArrayList("U", "D", "U", "U", "D", "U", "U", "D", "U", "U",
                            "D", "U", "U", "D", "U", "D", "D")
        ));
        return arguments.stream();
    }

    @DisplayName("이동한 다리 정보 형식을 변환해 현황 지도에 저장(실패 케이스)")
    @ParameterizedTest
    @MethodSource("generateArgumentStreamForFail")
    void addRoundsWithFail(String expected, List<String> moving) {
        MovingMap movingMap = new MovingMap();
        String lastMoving = moving.get(moving.size() - 1);
        moving.remove(moving.size() -1);
        moving.forEach(move -> movingMap.addOneRound(false, move));
        movingMap.addOneRound(true, lastMoving);

        assertThat(movingMap.toString()).isEqualTo(expected);
    }

    private static Stream<Arguments> generateArgumentStreamForFail() {
        List<Arguments> arguments = new LinkedList<>();
        arguments.add(Arguments.of("[ O | O |   ]\n[   |   | X ]", newArrayList("U", "U", "D")));
        arguments.add(Arguments.of("[ O |   | X ]\n[   | O |   ]", newArrayList("U", "D", "U")));
        arguments.add(Arguments.of(
                "[ O |   | O | O |   | O | O |   | O | O |   | O | O |   | O |   | X ]\n" +
                "[   | O |   |   | O |   |   | O |   |   | O |   |   | O |   | O |   ]",
                newArrayList("U", "D", "U", "U", "D", "U", "U", "D", "U", "U",
                            "D", "U", "U", "D", "U", "D", "U")
        ));
        return arguments.stream();
    }

}