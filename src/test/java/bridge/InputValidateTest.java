package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {
  InputValidate inputValidate = new InputValidate();

  @DisplayName("입력된 사이즈가 숫자가 아닌 경우면 예외가 발생한다.")
  @Test
  void isDigitBridgeSize() {
    String test1 = "a123";
    String test2 = "12a5";
    String test3 = "1234"; // 올바른 케이스
    assertThatThrownBy(() -> inputValidate.isDigitBridgeSize(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> inputValidate.isDigitBridgeSize(test2))
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

    assertThatThrownBy(() -> inputValidate.isInRangeBridgeSize(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> inputValidate.isInRangeBridgeSize(test2))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> inputValidate.isInRangeBridgeSize(test3))
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
    assertThatThrownBy(() -> inputValidate.isValidLength(test1))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> inputValidate.isValidLength(test2))
            .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> inputValidate.isValidLength(test3))
            .isInstanceOf(IllegalArgumentException.class);
//    assertThatThrownBy(() -> inputValidate.isValidLength(test4))
//            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("String으로 들어온 첫 글자가 U, P가 아니라면 예외가 발생한다.")
  @Test
  void isValidMoving() {
    String test1 = "U";
    String test2 = "P";
    String test3 = "Uqwerjlk";
    String test4 = "Pqwer";
    String test5 = "adfjU";

    assertThatThrownBy(() -> inputValidate.isValidMoving(test1))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void isValidCommand() {
  }
}