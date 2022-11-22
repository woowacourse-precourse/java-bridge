package bridge.view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    static InputView inputView;

    @BeforeAll
    static void setInputViewTest() {
        inputView = new InputView();
    }

    @DisplayName("아무것도 입력 안했을때 확인")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void userInputEmptyTest(String userInput) {
        assertThatThrownBy(()-> {
            inputView.userInputEmptyException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자아닐때 확인")
    @ValueSource(strings = {"朴", "#", "a1", " 12"})
    @ParameterizedTest
    void notNumberTest(String userInput) {
        assertThatThrownBy(()-> {
            inputView.notNumberException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이 범위가 벗어나는 것 확인")
    @ValueSource(ints = {1,3,20,21})
    @ParameterizedTest
    void outOfBridgeSizeTest(int userInput) {
        assertThatThrownBy(()-> {
            inputView.outOfBridgeSizeException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
