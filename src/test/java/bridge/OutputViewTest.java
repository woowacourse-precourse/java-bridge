package bridge;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;


public class OutputViewTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class PrintMapTest {

        OutputStream originOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputView ov = new OutputView();

        @BeforeAll
        void changeOutputStream() {
            System.setOut(new PrintStream(out));
        }

        @AfterAll
        void getBackOutputStream() {
            System.setOut((PrintStream) originOut);
        }

        @ParameterizedTest(name="시나리오 {index}")
        @MethodSource("testPrintMapArgument")
        @DisplayName("시나리오 테스트")
        void testPrintMap(List<String> map, List<String> user, String upperBridgeString, String underBridgeString){
            ov.printMap(map,user);
            assertThat(out.toString())
                    .contains(underBridgeString,underBridgeString);
        }
        Stream<Arguments> testPrintMapArgument(){
            return  Stream.of(
                    Arguments.arguments(
                            List.of("U","D","U","D"),
                            List.of("U","D","U","D"),
                            "[ O |   | O |   ]",
                            "[   | O |   | O ]"
                    ),
                    Arguments.arguments(
                            List.of("U","D","U","D"),
                            List.of("U","D","U"),
                            "[ O |   | O ]",
                            "[   | O |   ]"
                    ),
                    Arguments.arguments(
                            List.of("U","D","U","D"),
                            List.of("U","D","U","U"),
                            "[ O |   | O | X ]",
                            "[   | O |   |   ]"
                    )
            );
        }
    }
}
