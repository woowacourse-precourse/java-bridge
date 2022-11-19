package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @DisplayName("유효성 검사 테스트")
    @Test
    public void validationTest(){
        InputView inputView = new InputView();
        assertThat(inputView.readBridgeSizeValidation("15a")).isFalse();
        assertThat(inputView.readBridgeSizeValidation("33")).isFalse();
        assertThat(inputView.readMovingValidation("U")).isTrue();
        assertThat(inputView.readGameCommandValidation("X")).isFalse();
    }
}
