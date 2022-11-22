package bridge.validator.view;

import bridge.exception.NotIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberInputValidatorTest {
  @ParameterizedTest(name = "{index}: {displayName} input:{0}")
  @DisplayName("정수로 변환할 수 없는 문자열을 넣으면 예외가 반환된다.")
  @ValueSource(strings = {"d", "U", " "})
  void canNotInputInvalidString(String input) {
    assertThrows(NotIntegerException.class, () -> NumberInputValidator.validate(input));
  }

  @ParameterizedTest(name = "{index}: {displayName} input:{0}")
  @DisplayName("정수로 변환할 수 있는 문자열을 넣는다.")
  @ValueSource(strings = {"3", "6", "20"})
  void inputValidStringTest(String input) {
    assertDoesNotThrow(() -> NumberInputValidator.validate(input));
  }
}
