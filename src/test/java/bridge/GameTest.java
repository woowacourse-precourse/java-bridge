package bridge;

import bridge.Utils.Validation;
import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest extends NsTest {

    @Test
    @DisplayName("사용자의 잘못된 입력의 예외처리를 테스트합니다.")
    void userInputException() {
        Validation validate = new Validation();

        assertThatThrownBy(() -> validate.checkSizeReturnInt("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validate.checkSizeReturnInt("X"))
                .isInstanceOf(NumberFormatException.class);

        assertThatThrownBy(() -> validate.checkProperDirection("X"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validate.checkGameCommandInput("X"))
                .isInstanceOf(IllegalArgumentException.class);
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
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}