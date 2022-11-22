package bridge;


import static org.assertj.core.api.Assertions.assertThat;

import bridge.controller.BridgeController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class BridgeGameTest {
    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);


    @BeforeEach
    void setUp() {
        System.setOut(printStream);

    }

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }



    private final BridgeController bridgeController = new BridgeController();


    @DisplayName("다리 길이 3. 게임 실패 경우")
    @ParameterizedTest
    @MethodSource("bridge_len3_lose_param")
    void bridge_len3_lose(String input, List<String> expected) {
        List<String> bridge_len3 = Arrays.asList("D", "D", "U");
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        bridgeController.newGame(bridge_len3);
        assertThat(outputStream.toString().trim()).contains(expected);
    }

    static Stream<Arguments> bridge_len3_lose_param() {
        return Stream.of(
                Arguments.of("D\nD\nD\nQ",
                        Arrays.asList("최종 게임 결과",
                                "[   |   |   ]",
                                "[ O | O | X ]",
                                "게임 성공 여부: 실패",
                                "총 시도한 횟수: 1"))
        );
    }
}
