package bridge;

import bridge.Utils.Validation;
import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @Test
    @DisplayName("다리의 표현을 확인합니다.")
    void bridgeToString() {
        List<String> testBridge = List.of("U", "U", "D", "D");
        String expectedUpperPath = "[ O | O |   |   ]";
        String expectedLowerPath = "[   |   | O | O ]";

        OutputView output = new OutputView();
        output.printMap(testBridge, "X", true);
        assertThat(output()).contains(expectedUpperPath);
        assertThat(output()).contains(expectedLowerPath);

        expectedUpperPath = "[ O | O |   |   |   ]";
        expectedLowerPath = "[   |   | O | O | X ]";

        output.printMap(testBridge, "D", false);
        assertThat(output()).contains(expectedUpperPath);
        assertThat(output()).contains(expectedLowerPath);
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}