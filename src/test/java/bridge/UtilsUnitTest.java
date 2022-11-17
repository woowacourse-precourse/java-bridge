package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilsUnitTest {
    private final BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("사용자가 선택한 칸이 이동 가능한 칸이면 O, 불가능한 칸이면 X를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0, X", "1, O", "2, X", "3, O"})
    void checkCrossabilityTest(int currBridgeIdx, String expectedResult) {
        String userInput = "D";
        List<String> testAnswerBridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));

        String actualResult = bridgeGame.move(currBridgeIdx, testAnswerBridge, userInput);
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}
