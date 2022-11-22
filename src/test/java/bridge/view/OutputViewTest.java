package bridge.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private OutputView outputView;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();

        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    static Stream<Arguments> generatePrintMapTestArgs() {
        return Stream.of(
                Arguments.of(List.of("U", "D", "U"),List.of("U", "U"), "[ O | X ]\n[   |   ]"),
                Arguments.of(List.of("U", "D", "U"),List.of("U", "D"), "[ O |   ]\n[   | O ]"),
                Arguments.of(List.of("U", "D", "U"),List.of("U", "D", "U"), "[ O |   | O ]\n[   | O |   ]")
        );
    }

    @ParameterizedTest
    @MethodSource("generatePrintMapTestArgs")
    void printMapTest(List<String> bridge, List<String> movements, String expected) {
        outputView.printMap(bridge, movements);

        assertThat(captor.toString()).contains(expected);
    }

}