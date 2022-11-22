package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static bridge.constants.Constants.GAME_FAILED_MESSAGE;
import static bridge.constants.Constants.GAME_SUCCESS_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private OutputView outputView = new OutputView();

    @DisplayName("출력 화면을 확인한다.")
    @ParameterizedTest
    @MethodSource("generatedPrintTestData")
    void testSettingPrintLine(List<String> userWantedDirection, String command, String expected) {
        BridgeGame bridgeGame = setUpBridge();
        for (String movedDirection : userWantedDirection) {
            bridgeGame.move(movedDirection);
        }
        String result = outputView.settingPrintLine(bridgeGame,command).toString();
        assertThat(result).isEqualTo(expected);

    }

    @DisplayName("성공 여부 문자열을 확인한다.")
    @ParameterizedTest
    @MethodSource("generatedStatusTestData")
    void testCheckStatus(Status status, String expected) {
        assertThat(outputView.checkStatus(status)).isEqualTo(expected);
    }

    static Stream<Arguments> generatedStatusTestData() {
        return Stream.of(
                Arguments.of(Status.ENDING, GAME_SUCCESS_MESSAGE),
                Arguments.of(Status.PLAYING, GAME_FAILED_MESSAGE),
                Arguments.of(Status.FAIL, GAME_FAILED_MESSAGE)
        );
    }

    static Stream<Arguments> generatedPrintTestData() {
        return Stream.of(
                Arguments.of(List.of("D"), "D", "[ X ]"),
                Arguments.of(List.of("D"), "U", "[   ]"),
                Arguments.of(List.of("U"), "U", "[ O ]"),
                Arguments.of(List.of("U"), "D", "[   ]"),
                Arguments.of(Arrays.asList("U", "U"), "U", "[ O | X ]"),
                Arguments.of(Arrays.asList("U", "U"), "D", "[   |   ]"),
                Arguments.of(Arrays.asList("U", "D"), "U", "[ O |   ]"),
                Arguments.of(Arrays.asList("U", "D"), "D", "[   | O ]")
        );
    }

    BridgeGame setUpBridge() {
        return new BridgeGame(Arrays.asList("U", "D", "U"));
    }
}