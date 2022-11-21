package bridge;

import bridge.controller.ProgressGame;
import bridge.model.BridgeGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressGameTest {
    private static List<String> bridge;

    @BeforeAll
    static void initAll() {
        bridge = Arrays.asList("D","U","D");
    }

    @DisplayName("progress 단위 테스트(인풋값 ㅣ 정답)")
    @ParameterizedTest
    @MethodSource("provideFirstAndSecond")
    void checkCorrect(String input, String lastInput, String answer) {
        BridgeGame game = new BridgeGame(bridge);
        InputStream in = createInputStream(input, lastInput);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setIn(in);
        new ProgressGame(game);
        assertThat(out.toString()).contains(answer);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public static Stream<Arguments> provideFirstAndSecond() {
        return Stream.of(
                Arguments.of("D\nU\n", "D", "최종 게임 결과\n" +
                                                                "[   | O |   ]\n" +
                                                                "[ O |   | O ]\n\n" +
                                                                "게임 성공 여부: 성공\n" +
                                                                "총 시도한 횟수: 1"),
                Arguments.of("D\nD\n", "Q", "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R,종료: Q)\n" +
                                                        "최종 게임 결과\n" +
                                                        "[   |   ]\n" +
                                                        "[ O | X ]\n\n" +
                                                        "게임 성공 여부 : 실패\n" +
                                                        "총 시도한 횟수: 1"),
                Arguments.of("U\n", "Q", "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R,종료: Q)\n" +
                                                    "최종 게임 결과\n" +
                                                    "[ X ]\n" +
                                                    "[   ]\n\n" +
                                                    "게임 성공 여부 : 실패\n" +
                                                    "총 시도한 횟수: 1")
        );
    }

    private InputStream createInputStream(String input, String lastInput) {
        List<InputStream> streams = Arrays.asList(
                generateUserInput(input),
                generateUserInput(lastInput)
        );
        return new SequenceInputStream(Collections.enumeration(streams));
    }

}
