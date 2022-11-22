package bridge.view;

import bridge.model.Plate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    OutputView outputView;
    OutputStream out;

    @BeforeEach
    void beforeEach() {
        outputView = new OutputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("성공 여부에 따라 현재까지 움직인 경로 출력하는 테스트")
    @ParameterizedTest
    @MethodSource("expectedOutput")
    void printMapTest(boolean isSuccess, List<Plate> path, String expectedOutput) {
        outputView.printMap(isSuccess, path);
        assertThat(out.toString().trim())
                .isEqualTo(expectedOutput);
    }

    static Stream<Arguments> expectedOutput() {
        boolean success = true;
        List<Plate> path1 = List.of(Plate.UP_PLATE, Plate.DOWN_PLATE, Plate.UP_PLATE);
        String expected1 = "[ O |   | O ]\n[   | O |   ]";
        boolean fail = false;
        List<Plate> path2 = List.of(Plate.UP_PLATE, Plate.DOWN_PLATE, Plate.UP_PLATE);
        String expected2 = "[ O |   | X ]\n[   | O |   ]";
        return Stream.of (
                Arguments.of(success, path1, expected1),
                Arguments.of(fail, path2, expected2));
    }
}
