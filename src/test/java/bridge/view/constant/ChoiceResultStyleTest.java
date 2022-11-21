package bridge.view.constant;

import bridge.service.constant.ChoiceResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChoiceResultStyleTest {
    @DisplayName("ChoiceResult.CORRECT으로 style을 찾으면 \"O\" 를 반환한다.")
    @Test
    void When_FindStyleWithCorrectChoiceResult_Expect_O() {
        assertThat(ChoiceResultStyle.findStyleByChoiceResult(ChoiceResult.CORRECT))
                .isEqualTo("O");
    }

    @DisplayName("ChoiceResult.WRONG으로 style을 찾으면 \"X\" 를 반환한다.")
    @Test
    void When_FindStyleWithWrongChoiceResult_Expect_X() {
        assertThat(ChoiceResultStyle.findStyleByChoiceResult(ChoiceResult.WRONG))
                .isEqualTo("X");
    }

    @DisplayName("ChoiceResult.NOT_CHOSEN으로 style을 찾으면 \" \" 를 반환한다.")
    @Test
    void When_FindStyleWithNotChosenChoiceResult_Expect_SPACE() {
        assertThat(ChoiceResultStyle.findStyleByChoiceResult(ChoiceResult.NOT_CHOSEN))
                .isEqualTo(" ");
    }
}
