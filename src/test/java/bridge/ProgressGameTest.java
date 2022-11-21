package bridge;

import bridge.controller.ProgressGame;
import bridge.model.BridgeGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProgressGameTest {
    private static BridgeGame game;
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeAll
    static void initAll() {
        List<String> bridge = Arrays.asList("D","U","D");
        game = new BridgeGame(bridge);
    }

    @DisplayName("progress 단위 테스트(인풋값 ㅣ 테스트 내용)")
    @ParameterizedTest
    @MethodSource("provideFirstAndSecond")
    void checkCorrect(String first, String second, String explain) {
        InputStream in = createInputStream(first, second);
        System.setIn(in);
        new ProgressGame(game);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public static Stream<Arguments> provideFirstAndSecond() {
        return Stream.of(
                Arguments.of("D\nU\n", "D", "| case : 틀린값, 종료" ),
                Arguments.of("D\nD\n", "Q", "| case: 맞는값, 틀린값, 종료"),
                Arguments.of("U\n", "Q", "| case: 전부 맞는 값")
        );
    }

    private InputStream createInputStream(String first, String second) {
        List<InputStream> streams = Arrays.asList(
                generateUserInput(first),
                generateUserInput(second)
        );
        return new SequenceInputStream(Collections.enumeration(streams));
    }

}
