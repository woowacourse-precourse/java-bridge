package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(List.of("U", "U", "U", "D"));
    }

    @ParameterizedTest
    @MethodSource("정상_입력_생성")
    void move_정상_입력_반환값_테스트(List<String> moveCommands, List<Map<ChoiceOrResult, String>> expected) {
        List<EnumMap<ChoiceOrResult, String>> actual = null;
        for (String moveCommand : moveCommands) {
            actual = bridgeGame.move(moveCommand);
        }

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("비정상상태_입력_생성")
    void move_비정상상태_테스트(List<String> moveCommands) {
        assertThatThrownBy(() -> {
            for (String moveCommand : moveCommands) {
                bridgeGame.move(moveCommand);
            }
        }).isInstanceOf(IllegalStateException.class);
    }

    private static Stream<Arguments> 정상_입력_생성() {
        return Stream.of(Arguments.of(List.of("U", "U", "U", "U"),
                        List.of(Map.of(ChoiceOrResult.CHOICE, "U", ChoiceOrResult.RESULT, "O"),
                                Map.of(ChoiceOrResult.CHOICE, "U", ChoiceOrResult.RESULT, "O"),
                                Map.of(ChoiceOrResult.CHOICE, "U", ChoiceOrResult.RESULT, "O"),
                                Map.of(ChoiceOrResult.CHOICE, "U", ChoiceOrResult.RESULT, "X"))),
                Arguments.of(List.of("U", "U", "U", "D"),
                        List.of(Map.of(ChoiceOrResult.CHOICE, "U", ChoiceOrResult.RESULT, "O"),
                                Map.of(ChoiceOrResult.CHOICE, "U", ChoiceOrResult.RESULT, "O"),
                                Map.of(ChoiceOrResult.CHOICE, "U", ChoiceOrResult.RESULT, "O"),
                                Map.of(ChoiceOrResult.CHOICE, "D", ChoiceOrResult.RESULT, "O"))));
    }

    private static Stream<List<String>> 비정상상태_입력_생성() {
        return Stream.of(List.of("U", "U", "U", "U", "U"), List.of("U", "U", "U", "D", "D"));
    }

    @ParameterizedTest
    @CsvSource({"U,D,true", "U,U,false"})
    void wasFailedToMove(String moveCommand1, String moveCommand2, boolean expected) {
        bridgeGame.move(moveCommand1);
        bridgeGame.move(moveCommand2);

        assertThat(bridgeGame.wasFailedToMove()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("종료_입력_생성")
    void isCompleted(List<String> moveCommands, boolean expected) {
        for (var moveCommand : moveCommands) {
            bridgeGame.move(moveCommand);
        }

        assertThat(bridgeGame.isCompleted()).isEqualTo(expected);
    }

    private static Stream<Arguments> 종료_입력_생성() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "U", "D"), Boolean.TRUE),
                Arguments.of(List.of("U", "U", "D"), Boolean.TRUE),
                Arguments.of(List.of("U", "D"), Boolean.TRUE),
                Arguments.of(List.of("D"), Boolean.TRUE),
                Arguments.of(List.of("U", "U", "U"), Boolean.FALSE)
        );
    }

    @ParameterizedTest
    @MethodSource("재시작_입력_생성")
    void retry(List<String> moveCommands) {
        for (var moveCommand : moveCommands) {
            bridgeGame.move(moveCommand);
        }

        bridgeGame.retry();

        assertThat(bridgeGame.isCompleted()).isEqualTo(false);
    }

    private static Stream<List<String>> 재시작_입력_생성() {
        return Stream.of(
                List.of("U", "U", "U", "D"),
                List.of("U", "U", "D"),
                List.of("U", "D"),
                List.of("D"),
                List.of("U", "U", "U")
        );
    }
}