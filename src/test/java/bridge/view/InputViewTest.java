package bridge.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class InputViewTest {

    private InputView inputView = new InputView();

    @DisplayName("범위외의 숫자 또는 문자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "12ab", "ab12", "ab", "-ab", "-1ab", "0", "-12", "25", "1"})
    void createBridgeLengthWrongInputExceptionTest(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
           inputView.convertToInt(input);
        });
    }

    @DisplayName("범위 내의 숫자를 입력하면 통과한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5", "20", "19"})
    void createBridgeLengthWrongInputPassTest(String input) {
        int convertNumber = inputView.convertToInt(input);
        Assertions.assertEquals(convertNumber, Integer.parseInt(input));
    }
}