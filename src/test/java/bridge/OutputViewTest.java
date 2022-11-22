package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class OutputViewTest {

    public static Map map = new Map();
    public static OutputView outputView = new OutputView();

    @BeforeAll
    static void setup(){

        map.update("U", true);
        map.update("U", true);
        map.update("D", false);

    }

    @Test
    void printMap() {

        outputView.printMap(map);
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void printResult(Map map, boolean isGameCleared, int totalAttempts) {
        outputView.printResult(map, isGameCleared, totalAttempts);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(map, false, 3),
                Arguments.of(map, false, 56),
                Arguments.of(map, true, 1)
        );
    }

    @Test
    void printComment() {
        outputView.printComment(Comment.START_GAME, "더 하고싶은 말");
    }
}