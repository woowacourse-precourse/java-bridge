package bridge.domain.gameOver;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GameResultTest {
    @CsvSource(value = {
            "3 : D,U,D,D,D : [O , O,O ,O ,O ]"
    }, delimiter = ':')
    @ParameterizedTest
    void 최종_결과를_출력한다(int gameAttemptsCount, String originalBridgeInput, String currentBridgeInput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> currentBridge = Arrays.stream(removeBrackets(currentBridgeInput).split(","))
                .collect(Collectors.toList());

        List<String> originalBridge = Arrays.stream(originalBridgeInput.split(","))
                .collect(Collectors.toList());

        GameResult.takeResult(currentBridge, originalBridge, gameAttemptsCount);

        assertThat(outputStream.toString()).contains("최종 게임 결과");
        assertThat(outputStream.toString()).contains("[   | O |   |   |   ]");
        assertThat(outputStream.toString()).contains("[ O |   | O | O | O ]");
        assertThat(outputStream.toString()).contains("게임 성공 여부: 성공");
        assertThat(outputStream.toString()).contains("총 시도한 횟수: 3");
    }

    @CsvSource(value = {
            "true : D,U,D,D,D : [O , O,O ,O ,O ]",
            "false : D,D,D,U,U,U : [O ,O ,O , O, O,X ]",
            "false : U,U,U,U : [ O, O,X ]"
    }, delimiter = ':')
    @ParameterizedTest
    void 다리를_끝까지_건너는_것을_성공했는지_또는_실패했는지_확인한다(boolean expected, String originalBridgeInput, String currentBridgeInput) {
        List<String> currentBridge = Arrays.stream(removeBrackets(currentBridgeInput).split(","))
                .collect(Collectors.toList());

        List<String> originalBridge = Arrays.stream(originalBridgeInput.split(","))
                .collect(Collectors.toList());

        boolean result = GameResult.checkSuccessOrFailOfGameResult(currentBridge, originalBridge);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    String removeBrackets(String currentBridgeInput) {
        StringBuilder cutCurrentBridgeInput = new StringBuilder(currentBridgeInput);
        cutCurrentBridgeInput.deleteCharAt(cutCurrentBridgeInput.length() - 1);
        cutCurrentBridgeInput.deleteCharAt(0);

        return cutCurrentBridgeInput.toString();
    }
}