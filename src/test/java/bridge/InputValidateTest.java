package bridge;

import bridge.view.InputValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {

  @DisplayName("입력된 사이즈가 숫자가 아닌 경우면 예외가 발생한다.")
  @Test
  void isDigitBridgeSize() {
    String test1 = "a123";
    String test2 = "12a5";
    String test3 = "1234"; // 올바른 케이스
    assertThatThrownBy(() -> InputValidate.isDigitBridgeSize(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isDigitBridgeSize(test2))
            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> inputValidate.isDigitBridgeSize(test3))
//            .isInstanceOf(IllegalArgumentException.class);

  }

  @DisplayName("String으로 입력된 int로 파싱 후 사이즈가 3 ~ 20 사이가 아니라면 예외가 발생한다.")
  @Test
  void isInRangeBridgeSize() {
    int test1 = 2;
    int test2 = 29;
    int test3 = -1;
    int test4 = 15; // 올바른 케이스

    assertThatThrownBy(() -> InputValidate.isInRangeBridgeSize(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isInRangeBridgeSize(test2))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isInRangeBridgeSize(test3))
            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> inputValidate.isInRangeBridgeSize(test4))
//            .isInstanceOf(IllegalArgumentException.class);

  }

  @DisplayName("String으로 들어온 값이 한 글자가 아니라면 예외가 발생한다.")
  @Test
  void isValidLength() {
    String test1 = "123";
    String test2 = "";
    String test3 = "12";
    String test4 = "1"; // 통과 케이스
    assertThatThrownBy(() -> InputValidate.isValidLength(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidLength(test2))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidLength(test3))
            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> inputValidate.isValidLength(test4))
//            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("String의 길이 검사 후 한 글자가 U, P가 아니라면 예외가 발생한다.")
  @Test
  void isValidMoving() {
    String rangeOver1 = "adfjU";
    String rangeOver2 = "14afdP";
    String test1 = "U";
    String test2 = "P";
    String test3 = "R";
    String test4 = "Q";
    String test5 = "u";
    String test6 = "d";

    assertThatThrownBy(() -> InputValidate.isValidMoving(rangeOver1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidMoving(rangeOver2))
            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> InputValidate.isValidMoving(test1))
//            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> InputValidate.isValidMoving(test2))
//            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidMoving(test3))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidMoving(test4))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidMoving(test5))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidMoving(test6))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("String의 길이 검사 후 한 글자가 Q, R이 아니라면 예외가 발생한다.")
  @Test
  void isValidCommand() {
    String sizeOver1 = "adfjR";
    String sizeOver2 = "14afdQ";
    String test3 = "R";
    String test4 = "Q";
    String test5 = "D";
    String test6 = "U";
    String test7 = "r";
    String test8 = "q";

    assertThatThrownBy(() -> InputValidate.isValidCommand(sizeOver1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidCommand(sizeOver2))
            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> InputValidate.isValidCommand(test3))
//            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> InputValidate.isValidCommand(test4))
//            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidCommand(test5))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidCommand(test6))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidCommand(test7))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> InputValidate.isValidCommand(test8))
            .isInstanceOf(IllegalArgumentException.class);
  }
}