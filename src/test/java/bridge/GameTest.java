package bridge;

import bridge.Utils.Validation;
import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static bridge.Enums.GameMessage.COUNT_OF_RETRY;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest extends NsTest {

    @DisplayName("사용자의 잘못된 숫자입력의 예외처리를 테스트합니다.")
    @ValueSource(strings = {"1", "2", "99"})
    @ParameterizedTest
    void userInputOutOfBridgeSize(String input) {
        Validation validate = new Validation();

        assertThatThrownBy(() -> validate.checkSizeReturnInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 잘못된 문자입력의 예외처리를 테스트합니다.")
    @ValueSource(strings = {"U", "D", "R", "Q"})
    @ParameterizedTest
    void userInputNotNumberToBridgeSize(String input) {
        Validation validate = new Validation();

        assertThatThrownBy(() -> validate.checkSizeReturnInt(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("다리의 표현을 확인합니다.")
    @CsvSource(value = {
            "[ O | O |   |   ],[   |   | O | O ],true",
            "[ O | O |   |   |   ],[   |   | O | O | X ],false"})
    @ParameterizedTest
    void bridgeToString(String upperPath, String lowerPath, boolean isPassed) {
        OutputView output = new OutputView();
        List<String> bridge = List.of("U", "U", "D", "D");
        output.printMap(bridge, "D", isPassed);

        assertThat(output()).contains(upperPath);
        assertThat(output()).contains(lowerPath);
    }

    @Test
    @DisplayName("재시도 횟수를 확인합니다.")
    void countRetry() {
        String[] runInputs = new String[]{"3", "U", "U", "R", "U", "R", "U", "R", "U", "Q"};
        int expectedCount = 4;

        assertRandomNumberInRangeTest(() -> {
            run(runInputs);
            String expectedMessage = COUNT_OF_RETRY.getMessage() + expectedCount;
            assertThat(output()).contains(expectedMessage);
        }, 1, 0, 0);
    }

    @DisplayName("게임성공여부를 확인합니다.")
    @CsvSource(value = {
            "3 & U & D & R & D & R & D & Q,실패",
            "3 & D & Q,실패",
            "3 & U & U & U,성공",
            "3 & D & R & U & U & U,성공"})
    @ParameterizedTest
    void result(String runInputs, String expectedResult) {
        String[] inputArray = runInputs.split(" & ");
        assertRandomNumberInRangeTest(() -> {
            run(inputArray);
            assertThat(output()).contains(expectedResult);
        }, 1, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}