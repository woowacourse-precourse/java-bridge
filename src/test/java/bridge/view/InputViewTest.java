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
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void userInputEmptyTest(String userInput) {
        assertThatThrownBy(()-> {
            InputException.userInputEmptyException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자아닐때 확인")
    @ParameterizedTest
    @ValueSource(strings = {"朴", "#", "a1", " 12"})
    void notNumberTest(String userInput) {
        assertThatThrownBy(()-> {
            InputException.notNumberException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이 범위가 벗어나는 것 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,3,20,21})
    void outOfBridgeSizeTest(int userInput) {
        assertThatThrownBy(()-> {
            InputException.outOfBridgeSizeException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이동 입력 예외 처리 확인")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "123"})
    void notMoveCommandTest(String userInput) {
        assertThatThrownBy(()-> {
            InputException.notMoveCommandException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 재시작 여부 입력 예외처리 확인")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "123"})
    void notGameCommandException(String userInput) {
        assertThatThrownBy(()-> {
            InputException.notGameCommandException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
